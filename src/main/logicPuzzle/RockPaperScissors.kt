package main.logicPuzzle


/**
 * じゃんけんの論理パズル
 * https://twitter.com/ikeikey/status/1540468363540979715?s=20&t=hnLWf8UVePrf1aXUTabBVw
 *
 * 太郎くんと花子さんが以下の会話をしている
 * 花子:「昨日6人でじゃんけんをしたらね、 1回で勝ちと負けが分かれたの!私は負けちゃったんだけど、 勝ったのは何人だと思う?」
 * 太郎:「何かヒントがなくちゃ分からないよ」
 * 花子:「そうねぇ、そのとき6人が出した手の 「伸びている指の本数」を合わせたら、ちょうど太郎君の弟の年齢と同じになるわ」
 * 太郎:「ふむふむ･･･ (しばらく考える)... やっぱり分からないや」
 * 花子:「ちなみに、 すみれちゃんも負けたよ｣
 * 太郎 :｢そうか、 分かった。 勝ったのは ア人だね」
 * 花子:「当たり~!」
 * アに入る数を答えよ.
 *
 * */

fun main(args: Array<String>) {

    // 標準入力
    val players = 6

    judge(6)

}

fun judge(players: Int) {
    val minLooser = 1

    val firstAnswerCandidate = getCandidateGameResult(players, minLooser)
    val secondAnswerCandidate = getCandidateGameResult(players, minLooser + 1)

//    println("first=$firstAnswerCandidate \n second=$secondAnswerCandidate")

    val remainedCandidate = firstAnswerCandidate - secondAnswerCandidate

    val ans = remainedCandidate.filter { it.first.looser >= minLooser + 1 }
    if (ans.size == 1) {
        println("勝ったのは、${ans.first().first.winner}人だね")
    } else {
        println("「ふむふむ･･･ (しばらく考える)... やっぱり分からないや」")
    }
}

fun getCandidateGameResult(players: Int, minLooser: Int): List<Pair<GameResult, Int>> {
    val fingerResult = mutableListOf<Pair<GameResult, Int>>()

    val combination = generatePlayerCombination(players, minLooser)
    combination.forEach { result ->
        calcNumberOfFinger(result).forEach {
            fingerResult.add(Pair(result, it))
        }
    }

    val duplicatedFingerResult = findAllDuplicates(fingerResult.map { it.second })

    // candidate game result list
    return fingerResult.filter { duplicatedFingerResult.contains(it.second) }

}

/**
 * @return Pair<勝利人数、敗北人数>のプレイヤー分の組み合わせ
 * */
fun generatePlayerCombination(players: Int, minLooser: Int): List<GameResult> {
    val list = mutableListOf<GameResult>()

    if (players < 2 || minLooser >= players) return listOf()

    var numberOfLooser = minLooser

    while (players - 1 >= numberOfLooser) {
        val numberOfWinner = players - numberOfLooser
        list.add(GameResult(numberOfWinner, numberOfLooser))
        numberOfLooser++
    }

    return list
}


fun calcNumberOfFinger(result: GameResult): List<Int> {
    val rock = 0
    val scissors = 2
    val paper = 5

    val winRock = (result.winner * rock) + (result.looser * scissors)
    val winScissors = (result.winner * scissors) + (result.looser * paper)
    val winPaper = (result.winner * paper) + (result.looser * rock)

    return listOf(winRock, winPaper, winScissors)
}

/**
 * input : [4, 3, 2, 3, 1, 4, 5]
 * output: [3, 4]
 * */
fun findAllDuplicates(list: List<Int>): Set<Int> {
    val seen: MutableSet<Int> = mutableSetOf()
    return list.filter { !seen.add(it) }.toSet()
}

data class GameResult(
    val winner: Int,
    val looser: Int
)
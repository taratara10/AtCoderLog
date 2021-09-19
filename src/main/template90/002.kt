package main.template90


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val ans = mutableListOf<String>()
    val p = generateBitSearch(n)

    //奇数なら終了
    if (n%2 != 0) return

    for (item in p){
        var sum = 0
        //bit でtrue をカウントアップして 0下回ったら")"アウト　
        for (bit in item){
            if (bit) sum++
            else sum --

            if (sum < 0) break
        }
        if (sum == 0){
            ans.add(item.joinToString(separator = "") { if (it) "(" else ")" })
        }
    }
    ans.sort()
   for (a in ans) println(a)
}

fun generateBitSearch(n: Int): List<List<Boolean>>{
    val bitList = mutableListOf<List<Boolean>>()
    for (bit in 0 until (1 shl n)){
        val l = (n-1 downTo 0)
            .map { i -> ((bit shr i) and 1) == 1 } //bitが1ならtrueに変換
            .toList()
        bitList.add(l)
    }
    return bitList
}
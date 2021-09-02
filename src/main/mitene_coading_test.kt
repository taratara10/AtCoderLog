package main

//Q2. 一般的な英単語がリストになったテキストファイルが与えられます。重複する単語を全てprint出力してください。
//
//入力:
//
//# words.txt
//8
//apple
//machine
//telephone
//bite
//want
//apple
//pen
//bite
//
//出力:
//apple
//bite
fun main(){
    val n = readLine()!!.toInt()
    val l = List(n){
        readLine()!!
    }

    val h = HashSet<String>()
    val ans = mutableListOf<String>()

    for (item in l){
        //hashにaddできれば true
        val isNotContain = h.add(item)
        if (!isNotContain) ans.add(item)
    }

    println(ans)
}


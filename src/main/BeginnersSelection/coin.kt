package main.BeginnersSelection

fun main(args:Array<String>) {
    val a = readLine()!!.toInt()    //500
    val b = readLine()!!.toInt()    //100
    val c = readLine()!!.toInt()    //50
    val x = readLine()!!.toInt()    //合計金額
    var ans = 0

    for (i in 0..a){
        for (j in 0..b){
            for (k in 0..c){
                if (x == 500*i + 100*j + 50*k){
                    ans++
                }
            }
        }
    }

    println(ans)
}

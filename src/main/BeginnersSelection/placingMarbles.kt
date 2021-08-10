package main.BeginnersSelection

fun main(args:Array<String>){
    val s = readLine()!!
    var ans = 0

    //charはシングルクォート
    for (i in s.indices){
        if (s[i] == '1') ans++
    }
    println(ans)
}

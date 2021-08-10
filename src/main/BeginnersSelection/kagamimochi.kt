package main.BeginnersSelection

fun main(args:Array<String>){
    val n = readLine()!!.toInt()
    val l = List(n){
        readLine()!!.toInt()
    }.sorted()

    var current = 0
    var ans = 0
    for (i in l.indices){
        if (l[i] > current){
            current = l[i]
            ans++
        }
    }
    println(ans)
}
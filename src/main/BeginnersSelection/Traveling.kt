package main.BeginnersSelection

fun main (args:Array<String>){
    val n = readLine()!!.toInt()
    val l = Array(n+1){ Array(3){ 0 } }
    for (i in 0 until n){
        val (t,x,y) = readLine()!!.split(" ").map { it.toInt() }
        l[i][0] = t
        l[i][1] = x
        l[i][2] = y
    }

    //n+1で入れた0をfirstに持ってくる
    l.sortBy { it[0] }

    for (i in 0 until n){
        val time = l[i+1][0] - l[i][0]
        val dist = Math.abs((l[i+1][1] - l[i][1]) + (l[i+1][2] - l[i][2]))
        if (dist > time || dist%2 != time %2){
            println("No")
            return
        }
    }
    println("Yes")
}

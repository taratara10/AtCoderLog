package main.BeginnersSelection

fun main (arg:Array<String>){
    val n = readLine()!!.toInt()
    val l = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
    var sum = 0

    for (i in 0 until n){
        if (i%2 == 0){
            sum += l[i]
        }else{
            sum -= l[i]
        }
    }

    println(sum)
}
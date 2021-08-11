package main.ABC

fun main(args:Array<String>){
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }

    val b = a.sortedDescending()
    println(a.indexOf(b[1]) +1)
}

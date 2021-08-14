package main.ABC

fun main(args:Array<String>){
    val n = readLine()!!.toInt()
    if (1 <= n && n < 126) println(4)
    if (126 <= n && n < 212) println(6)
    if (212 <= n && n <= 214) println(8)
}
package main.ABC

fun main(){
    val n = readLine()!!.split(".").map { it.toInt() }
    val x = n[0]
    val y = n[1]
    val ans = when (y) {
        in 0..2 -> "$x-"
        in 3..6 -> "$x"
        else -> "$x+"
    }

    println(ans)

}
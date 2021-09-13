package main.ABC

fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    println(if (s[n-1] == 'o') "Yes" else "No")
}


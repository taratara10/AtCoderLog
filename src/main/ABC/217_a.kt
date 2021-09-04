package main.ABC

fun main(){
    val s = readLine()!!.split(" ")
    val s2 = s.sorted()
    println(if (s == s2) "Yes" else "No")
}


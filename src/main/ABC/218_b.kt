package main.ABC

fun main(){
    val p = readLine()!!.split(" ").map { it.toInt() }
    val l = "abcdefghijklmnopqrstuvwxyz"
    var s = ""

    for (i in p.indices){
        s += l[p[i]-1]
    }

    println(s)
}
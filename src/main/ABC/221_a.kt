package main.ABC

import kotlin.math.pow

fun main(args: Array<String>){
    val (a,b) = readLine()!!.split(" ").map { it.toInt() }
    val ans =32.0.pow(a-b).toInt()
    println(ans)
}

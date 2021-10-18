package main.ABC

import kotlin.math.pow

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val c = readLine()!!.split(" ").map { it.toLong() }.sorted()
    var ans = 1L

    for (i in 0 until n){
        ans *= Math.max((c[i]-i),0) % 1000000007
    }

    println(ans)

}
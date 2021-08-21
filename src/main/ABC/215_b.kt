package main.ABC

import kotlin.math.log2

//問題
//正整数 N が与えられるので、 2^k ≤ N となる最大の整数 k を求めてください。
fun main(){
    var n = readLine()!!.toLong()
    var ans = 0
    while (n > 0){
        n /= 2
        ans += 1
    }
    println(ans-1)
}

fun sub(){
    val n = readLine()!!.toDouble()
    println(log2(n).toInt())
}
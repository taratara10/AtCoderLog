package main.ABC

import kotlin.math.abs
import kotlin.math.min

fun main(args: Array<String>) {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toDouble() }.sorted()
    val b = readLine()!!.split(" ").map { it.toDouble() }.sorted()

    var ans = Double.MAX_VALUE

    var i = 0
    var j = 0

    while (i < n && j < m){
//無駄な条件分岐せずにシンプルにまとめような
//        if (a[i] == b[j]) {
//            ans = 0
//            break
//        }
//        if (a[i] > b[j]){
//            val dif = a[i] - b[j]
//            if (dif < ans) ans = dif
//            j++
//        }
//        if (b[j] > a[i]){
//            val dif = b[j] - a[i]
//            if (dif < ans) ans = dif
//            if (i < n) i++
//        }
//
        ans = min(ans, abs(a[i] - b[j]))
        if (a[i] > b[j]) j++
        else i ++

    }

    println(ans.toInt())
}

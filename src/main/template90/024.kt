package main.template90

fun main(args: Array<String>) {
    val (n,k) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }
    val b = readLine()!!.split(" ").map { it.toInt() }

    var sum = 0
    for (i in 0 until n ){
        sum += Math.abs(a[i] - b[i])
    }

    println(if ((k - sum)%2 == 0) "Yes" else "No")
}
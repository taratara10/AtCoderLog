package main.ABC

fun main(args: Array<String>) {
    val s1 = readLine()!!
    val s2 = readLine()!!
    val s3 = readLine()!!
    val t = readLine()!!

    var ans = ""

    for (i in t.indices){
        when (t[i]) {
            '1' -> ans += s1
            '2' -> ans += s2
            '3' -> ans += s3
        }
    }
    println(ans)
}
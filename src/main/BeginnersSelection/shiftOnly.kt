package main.BeginnersSelection

fun main(args:Array<String>) {
    val n = readLine()!!
    val a = readLine()!!.split(" ").map { it.toInt() }

    shiftOnly(a)
}

fun shiftOnly(a:List<Int>){
    var m = Int.MAX_VALUE

    for (i in a.indices){
        var count = 0
        var b = a[i]
        while (b%2 == 0){
            b /= 2
            count++
        }
        m = Math.min(m, count)
    }
    println(m)
}
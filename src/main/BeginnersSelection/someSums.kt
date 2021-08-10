package main.BeginnersSelection

fun main(args:Array<String>){
    val (n,a,b) = readLine()!!.split(" ").map { it.toInt() }
    var ans = 0

    for (i in a..n){
        var num = i
        var sum = 0

       for (j in 1..num.toString().length){
            sum += num%10
            num /=10
        }
        if (sum in a..b) ans += i
    }
    println("$ans")
}

package main.BeginnersSelection

fun main(args:Array<String>){
    val (a,b) = readLine()!!.split(" ").map { it.toInt() }
    product(a,b)
}

fun product(a:Int,b:Int){
    if ((a*b)%2 == 0) println("Even")
    else println("Odd")
}
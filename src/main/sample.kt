package main

fun main(args:Array<String>){
    val a = mutableListOf<List<Char>>()
    a += listOf<Char>()
    println(if (a[0].isEmpty())"Yes" else "No")
    println(a)
}

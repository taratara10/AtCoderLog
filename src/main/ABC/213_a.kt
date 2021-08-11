package main.ABC

fun main(args:Array<String>){
    val (a,b) = readLine()!!.split(" ").map { it.toInt() }

    println(a xor b)
//    for (i in 0..255){
//        if (a xor i == b){
//            println(i)
//            return
//        }
//    }
}

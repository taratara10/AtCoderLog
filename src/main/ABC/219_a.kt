package main.ABC

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    if (n >= 90){
        println("expert")
    } else if (n in 70..89){
        println("${90 - n}")
    } else if (n in 40..69){
        println("${70 - n}")
    } else if (n in 0..39){
        println("${40 - n}")
    }

}
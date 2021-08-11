package main.ABC

fun main(args:Array<String>){

    val (H,W,N) = readLine()!!.split(" ").map { it.toInt() }
    val cards = Array(N){ Array(2){ 0 } }
    for ( i in 0 until N){
        val (a,b) = readLine()!!.split(" ").map { it.toInt() }
        cards[i][0] = a
        cards[i][1] = b
    }

//    val sortedH = cards.map { it.first() }.


}


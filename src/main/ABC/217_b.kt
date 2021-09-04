package main.ABC

fun main(){
    val l = List(3){
        readLine()
    }

    val contest = mutableListOf("ABC","ARC","AGC","AHC")
    for (i in l){
        contest.remove(i)
    }
    println(contest.first())
}


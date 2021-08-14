package main.ABC

fun main(args:Array<String>){
    val (s,t) = readLine()!!.split(" ").map { it.toInt() }
    var ans = 0

    for (a in 0..s){
        for (b in 0..s){
            for (c in 0..s){
                if (a+b+c <= s && a*b*c <=t) ans++
            }
        }
    }

    println(ans)
}

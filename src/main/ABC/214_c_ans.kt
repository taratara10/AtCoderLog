package main.ABC
fun main(){
    val n = readLine()!!.toInt()
    val s = readLine()!!.split(" ").map { it.toInt() }
    val t = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    for (i in 1..2*n){
        t[(i+1)%n] = Math.min(t[(i+1)%n], t[i%n]+ s[i%n])
    }
    for (j in 0..n-1) println(t[j])
}

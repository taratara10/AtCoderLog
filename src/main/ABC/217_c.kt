package main.ABC

fun main(){
    val n = readLine()!!.toInt()
    val p = readLine()!!.split(" ").map { it.toInt() }

    val ans = MutableList(n){0}
    for (i in 0..n-1){
        ans[p[i]-1] = i+1
    }

    println(ans.joinToString(" "))
}


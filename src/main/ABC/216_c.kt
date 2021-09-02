package main.ABC

fun main(){
    var n = readLine()!!.toLong()

    var ans = ""
    while (n > 1L){
        //ちょうど割り切れる
        if (n%2L == 0L){
            n /= 2
            ans = "B$ans"
        }else{
            n --
            ans = "A$ans"
        }
    }
    println("A$ans")
}
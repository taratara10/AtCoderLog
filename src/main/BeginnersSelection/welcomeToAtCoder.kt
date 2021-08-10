package main.BeginnersSelection

fun main(){
    val a = readLine()!!.toInt()
    val (b,c) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!

    welcomeToAtCoder(a,b,c,s)

}

fun welcomeToAtCoder(a:Int,b:Int,c:Int,s:String){
    println("${a+b+c} $s")
}
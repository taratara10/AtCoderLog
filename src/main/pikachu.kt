package main

fun main(args: Array<String>) {

    val step = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }

    when (step){
        1 -> step1(n)
        2 -> step2(n, a)
        3 -> step3(n, a)
        4 -> step4(n, a)
    }
}

fun step1(n:Int){
    val search = n/2
    val harvest = n - search

    println(search * harvest)
}

fun step2(n: Int, a: List<Int>){
    val bit = generateBitSearch(n)
    var ans = 0L

    for (pattern in bit){
        var tree = 0L
        var sum = 0L
        for ((i, p) in pattern.withIndex()){
            if (p) tree += a[i]
            else sum += tree
        }
        ans = Math.max(ans,sum)
    }

    println(ans)
}

fun step3(n: Int, a: List<Int>){
    var tree = 0
    var sum = 0
    for(i in 0..n-2){
        println("$i days: tree${a[i]}  totalTree:$tree totalSum:$sum")
        if (a[i] > tree/(n-i-1)) tree += a[i]
        else sum += tree
    }
    sum += tree
    println(sum)
}

fun step4(n: Int, a: List<Int>){

}

//[true,false, ...]のbit全探索を生成
fun generateBitSearch(n: Int): List<List<Boolean>>{
    val bitList = mutableListOf<List<Boolean>>()
    for (bit in 0 until (1 shl n)){
        val l = (n-1 downTo 0)
            .map { i -> ((bit shr i) and 1) == 1 } //bitが1ならtrueに変換
            .toList()
        bitList.add(l)
    }
    return bitList
}

//        println("$i days: tree$s  totalTree:$tree totalSum:$sum")
//        println(n-i)
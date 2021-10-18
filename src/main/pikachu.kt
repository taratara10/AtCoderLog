package main

fun main(args: Array<String>) {

    val step = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }

    when (step){
        1 -> step1(n)
        2 -> step2(n, a)
        3 -> step31(n, a)
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

//fun step3(n: Int, a: List<Int>){
//    var tree = 0
//    var sum = 0
//    for(i in 0..n-2){
//        println("$i days: tree${a[i]}  totalTree:$tree totalSum:$sum")
//        if (a[i] > tree/(n-i-1)) tree += a[i]
//        else sum += tree
//    }
//    sum += tree
//    println(sum)
//}

fun step31(n: Int, a: List<Int>){
    var ans = 0
    for (m in 1 until n){
        var tree = a[0]
        var sum = 0
        var harvest = m
        for(i in 1..n-2){
            if ((a[i] > tree/(avoidDivideZero(harvest))) && (n-i) > harvest) {
                println("${((a[i-1] > tree/(avoidDivideZero(harvest))) && (n-i) > harvest)}/ $tree /$sum ")
                tree += a[i]
            }
            else {
                println("${((a[i-1] > tree/(avoidDivideZero(harvest))) && (n-i) > harvest)}/ $tree /$sum ")
                sum += tree
                harvest--
            }
        }
        sum += tree
        println("$harvest /$m/$sum")
        ans = Math.max(ans,sum)
    }
    println(ans)
}

fun step3(n: Int, a: List<Int>){
    val schedule = mutableListOf<Boolean>()
    val b = a.reversed()

    fun isSearch(m: Int,tree: Int): Pair<Int,Int>{
        //base case
        if (m == 1) {
            schedule.add(false)
            return Pair(1,tree)
        }

        if (tree < b[m]/ isSearch(m-1,tree).first){
            schedule.add(0,true)
            return Pair(schedule.count{ !it }, tree + b[m])
        }else{
            schedule.add(0,false)
            return Pair(schedule.count{ !it }, tree)
        }
    }

    isSearch(n-1,a[0])
    //1日目
    schedule.add(0,true)
    println(schedule)

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

fun avoidDivideZero(n: Int): Int {
    return if ((n -1) < 1)  1
    else n -1
}
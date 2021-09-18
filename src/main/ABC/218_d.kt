package main.ABC

import com.sun.xml.internal.xsom.impl.UName.comparator

// https://atcoder.jp/contests/abc218/tasks/abc218_d
fun main(args:Array<String>){
    val n = readLine()!!.toInt()
    val xy = List(n){
        readLine()!!
            .split(" ")
            .map { it.toInt() }
            .let { Pair(it.component1(),it.component2()) }
    }
    val xySet = xy.toSet()
    var ans = 0

    //組み合わせ
    for (i in 0 until n){
        for (j in i+1 until n){
            val (x1, y1) = xy[i]
            val (x2, y2) = xy[j]

            //直線上にない2点を選ぶ
            if ((x1 != x2)
                &&(y1 != y2)
                &&(Pair(x1,y2) in xySet)
                &&(Pair(x2,y1) in xySet)) ans ++
        }
    }

    println(ans/2)
}
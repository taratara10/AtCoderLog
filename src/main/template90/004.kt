package main.template90

fun main(args:Array<String>){
    val (h,w) = readLine()!!.split(" ").map { it.toInt() }
    val a = List(h){
        readLine()!!.split(" ").map { it.toInt() }
    }

    val memoRow = MutableList(h){ 0 } //行　w
    val memoCol = MutableList(w){ 0 } //列 h

    //固定する軸を考えるとわかりやすい
    for (col in 0 until h){
        memoRow[col] = a[col].sum()
        for (row in 0 until w){
            memoCol[row] += a[col][row]
        }
    }

    for (i in 0 until h){
        val p = mutableListOf<Int>()
        for (j in 0 until w){
            p += memoCol[j] + memoRow[i] - a[i][j]
        }
        println(p.joinToString(separator = " "))
    }
}
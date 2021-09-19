package main.template90


fun main(args:Array<String>){
    val (n, l) = readLine()!!.split(" ").map { it.toInt() }
    val k = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.sorted()

    //二分探索で0-Nに分割できるか
    val ans = myBinarySearch(0,l){
        canSplit(l,k,a,it)
    }

    println(ans)
}

//今回は下限を知りたいので、左側へ走査していくbinarySearch
fun myBinarySearch(start: Int, end: Int, isOk: (key: Int) -> Boolean): Int {
    var left = start
    var right = end

    while ((right - left) > 1){
        val mid = left + (right - left)/2
        //左へ進む
        if (isOk(mid)) left = mid
        else right = mid
    }

    //left は条件を満たさない最大の値、right は条件を満たす最小の値になっている
    return right -1
}

fun canSplit(l: Int, k: Int, a: List<Int>, boundary: Int): Boolean{
    var count = 0
    var position = 0

    for (item in a){
        if (count == k) break
        if ((item - position) >= boundary){
            count++
            position = item
        }
    }
    //k個以上に分割できるならtrue
    return (count >= k && (l-position) >= boundary)
}
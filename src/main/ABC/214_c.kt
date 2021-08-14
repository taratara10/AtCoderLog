package main.ABC

fun main(args:Array<String>){
    val n = readLine()!!.toInt()
    val s = readLine()!!.split(" ").map { it.toInt() }
    val t = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    //i時間に　j番目がhandOver
    val mMap = mutableMapOf<Int,Int>()

    var i =0
    var circle = MutableList(n){0}
    var ans = MutableList(n){0}
    while (ans.contains(0)){
        i++

        //tで宝石をもらう処理 ti番目
        for (ll in 0..t.size-1){

        if (t[ll] == i) {
            circle[ll]++
            if (ans[ll] == 0 || ans[ll] > i) ans[ll] = i
            //i + Si時間後にtiがhandoverを実行
            mMap.put(i+s[ll],ll)
        }
        }

        //hashを検索・実行→セット
        val j = mMap[i] ?: -1
        if(j >= 0) {
            while (circle[j] != 0) {
                circle[j]--
                if (j + 1 <= circle.size - 1) {
                    circle[j + 1]++
                    mMap.put(i+s[j+1],j+1)
                    if (ans[j+1] == 0 || ans[j+1] > i+ s[j+1]) ans[j+1] = i
                } else {
                    circle[0]++
                    mMap.put(i+s[0],0)
                    if (ans[0] == 0 || ans[0] > i+ s[0]) ans[0] = i
                }
            }
        }
    }

    for (k in 0..ans.size-1){
        println(ans[k])
    }

}




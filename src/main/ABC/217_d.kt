package main.ABC

fun main(){
    val l = readLine()!!.split(" ").map { it.toInt() }
    val query = List(l[1]){
        readLine()!!.split(" ").map { it.toInt() }
    }
    val wood = MutableList(l[0]){it}
    val ans = mutableListOf<List<Int>>(wood)

    val a = mutableListOf<Int>()

    for (ii in 0..l[1]-1){
        val q = query[ii]

        //切り出し
        if (q[0] == 1){
            //全てのpartに対して
            for (jj in 0..ans.size-1){
                val part = ans[jj]
                //切断部分があったら
                val i = part.indexOf(q[1])
                if ( i != -1){
                    ans.add(part.take(i))
                    ans.add(part.takeLast(part.size - i))
                    ans.remove(part)

                }
            }
        }

        //出力
        if (q[0] == 2){
            for (j2 in 0..ans.size-1){
                val part = ans[j2]
                if (part.contains(q[1])){
                    a.add(part.size)
                }
            }
        }
    }

    for (t in a) println(t)

}
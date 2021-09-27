package main.ABC

fun main(args: Array<String>) {
    val x = readLine()!!
    val n = readLine()!!.toInt()
    val s = List(n){
        readLine()!!
    }.toMutableList()

    val originalX = "abcdefghijklmnopqrstuvwxyz"
    //辞書順のPairを作成して、これをもとに変換する
    //newX = {z=a, y=b, x=c, w=d, ...}
    val newX = (0..25).associate { x[it] to originalX[it] }

    //StringBuilderでnewXに変換する
    val newName = { str: String ->
        buildString {
            str.forEach {
                this.append(newX[it])
            }
        }
    }

    s.map { Pair(it, newName(it)) }
        .sortedBy { it.second }
        .forEach { println(it.first) }
}


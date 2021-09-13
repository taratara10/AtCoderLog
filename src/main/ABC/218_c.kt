package main.ABC

fun main(args:Array<String>){
    val n = readLine()!!.toInt()
    val s = List(n){
        readLine()!!.toList()
    }
    val l = List(n){
        readLine()!!.toList()
    }
    println(if (validShapes(n,s,l)) "Yes" else "No")
}

fun validShapes(n: Int, s:List<List<Char>>, l: List<List<Char>>): Boolean {
    var rolled = s
    var ans = false

    val translatedL = translateTopLeft(n, l)

    for (time in 0..3){
        //回転する処理
        rolled = roll90(n,rolled)

        //検証
        val t =translateTopLeft(n,rolled)
        if (t == translatedL){
            ans = true
        }
    }
    return ans
}

//回転する処理
fun roll90(n: Int, s:List<List<Char>>): List<List<Char>> {
    val rolled = mutableListOf<List<Char>>()
    for (i in 0 until n){
        val line = mutableListOf<Char>()
        for (j in n-1 downTo 0){
            line.add(s[j][i])
        }
        rolled.add(line)
    }
    return rolled
}

fun translateTopLeft(n: Int, s: List<List<Char>>): List<List<Char>> {
   val translated = s.toMutableList()

    //translate top
    for (i in 0 until n){
        //i段目に#がなければ削除
        if (!s[i].contains('#')) {
            translated.remove(s[i])
        }else break
    }

    //translate left
    for (j in 0 until n){
        //n列目に#が含まれているか
        var notContainSharpColumn = -1
        for (k in 0 until n){
           if (s[k][j] == '#') {
               notContainSharpColumn = j
           }

        }

        //走査の結果n列目が全て'.'だった
        if (notContainSharpColumn == -1){
            for (col in 0 until translated.size){
                translated[col] = translated[col].drop(1)
            }
        }else break
    }

    return trim(translated)
}



//前後の'.'をtrimする処理
fun trim( s: List<List<Char>>): List<List<Char>> {
    val trim = mutableListOf<List<Char>>()

    //左辺を取り除く
    for (i in s.indices){
        val c = s[i].dropLastWhile { it == '.' }
        trim += c.ifEmpty { listOf() }
    }

    //下段を取り除く
    for (j in s.size-1 downTo 0){
        if (trim[j].isEmpty()) trim.remove(trim[j])
        else break
    }

    return trim
}


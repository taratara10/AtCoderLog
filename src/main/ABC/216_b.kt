package main.ABC

fun main(){
    val n = readLine()!!.toInt()
    val s = List(n) {
        readLine()!!.split(" ").map { it.toString() }
    }

    var ans = "No"
    for (i in 0..s.size-2){
        var j = i
        while (true){
            j++
            if (j > s.size-1) break
            if (s[i][0] == s[j][0] && s[i][1] == s[j][1]) {
                ans = "Yes"
                break
            }
        }
    }
    println(ans)
}

//別解
fun ans(){
    val n = readLine()!!.toInt()
    val s = HashSet<String>()

    //HashSet#add :Booleanを返す
    val ans = if ((1..n).all { s.add(readLine()!!) }) "No" else "Yes"
    println(ans)
}
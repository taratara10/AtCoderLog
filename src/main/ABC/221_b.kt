package main.ABC

fun main(args: Array<String>) {
    val s = readLine()!!.toList().map { it.toString() }
    val t = readLine()!!.toList().map { it.toString() }
    val n = s.size-1

    typo(s,t)
//    var ans = true
//    var count = 0
//
//    if (s == t) {
//        println("Yes")
//        return
//    }
//
//    for (i in 0..n-1){
//        if (s[i] != t[i]){
//            if (s[i] == t[i+1] && s[i+1] == t[i]){
//                count ++
//            }else{
//                ans = false
//            }
//        }
//    }
//
//    if (s[n] != t[n] && s[n-1] == t[n-1]) ans = false
//    if (count >= 2) ans = false
//
//    println(if (ans)"Yes" else "No")

}

fun typo(s: List<String>, t:List<String>){
    val a = mutableListOf<String>()
    for (i in 0..s.size-2){
        val l = s.toMutableList()
        val item = l.removeAt(i)
        l.add(i,item)
        a.add(l.joinToString { "" })
    }
    println(a)
    val ti = t.joinToString { "" }
    println(if (a.contains(ti))"Yes" else "No")
}
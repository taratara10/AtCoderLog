package main.template90

fun main(args: Array<String>) {
    val (N, p, q) = readLine()!!.split(" ").map { it.toLong() }
    val a = readLine()!!.split(" ").map { it.toLong() }
    val n = N.toInt()

    var count = 0
    for (i in 0 until n-4){
        for (j in i + 1 until n-3){
            val ij = a[i] * a[j] % p
            for (k in j +1 until  n-2){
                val ijk = ij * a[k] % p
                for (l in k + 1 until n-1){
                    val ijkl = ijk * a[l] % p
                    for (m in l + 1 until n){
                        if (ijkl * a[m] % p == q) count ++
                    }
                }
            }
        }
    }

    println(count)
}
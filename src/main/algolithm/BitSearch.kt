package main.algolithm


fun main(args:Array<String>){
    println(generateBitSearch(3))
}

fun generateBitSearch(n: Int): List<List<Boolean>>{
    val bitList = mutableListOf<List<Boolean>>()
    for (bit in 0 until (1 shl n)){
        val l = (n-1 downTo 0)
            .map { i -> ((bit shr i) and 1) == 1 } //bitが1ならtrueに変換
            .toList()
        bitList.add(l)
    }
    return bitList
}

//n = 3
//[[false, false, false], [false, false, true], [false, true, false], [false, true, true], [true, false, false], [true, false, true], [true, true, false], [true, true, true]]

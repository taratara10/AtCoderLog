package main.LeetCode

class `118_pascals_triangle` {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) return listOf()
        var res = mutableListOf<MutableList<Int>>()

        res.add(mutableListOf(1))
        if (numRows == 1) return res

        res.add(mutableListOf(1,1))

        for (i in 2..numRows-1){
            val list = mutableListOf<Int>(1)
            for (j in 1..i-1){
                val item = res[i-1][j-1] + res[i-1][j]
                list.add(item)
            }
            list.add(1)
            res.add(list)
        }
        return res
    }
}
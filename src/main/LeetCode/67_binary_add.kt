package main.LeetCode

class `67_binary_add` {
    fun addBinary(a: String, b: String): String {
        return (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
    }
}

//Input
//"11"
//"1"

//Output
//"100"
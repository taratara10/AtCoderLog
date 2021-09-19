package main.algolithm

fun main(args: Array<String>) {
    println(myBinarySearch(0,100) { it > 50 })
}

fun myBinarySearch(start: Int, end: Int, isOk: (key: Int) -> Boolean): Int {
    var left = start
    var right = end

    while ((right - left) > 1){
        val mid = left + (right - left)/2
        if (isOk(mid)) right = mid
        else left = mid
    }

    //left は条件を満たさない最大の値、right は条件を満たす最小の値になっている
    return right
}



//fun <T> List<T>.myBinarySearch(isOk: (T) -> Boolean): Int {
//    return myBinarySearch(-1, size) { index -> isOk(get(index)) }
//}
//
//fun <T> Array<T>.myBinarySearch(isOk: (T) -> Boolean): Int {
//    return myBinarySearch(-1, size) { index -> isOk(get(index)) }
//}
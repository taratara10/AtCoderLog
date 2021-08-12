package main.LeetCode

class `69_sqrt__binarySearch` {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        if (x < 4 ) return 1
        if (x < 9 ) return 2

        var start:Long = 3
        var end:Long = (x/2).toLong()
        var ans = 0

        while (start <= end){
            val mid = (start + end)/2
            val midSqu = mid * mid

            if (midSqu == x.toLong()) return mid.toInt()
            //(start<=end)を壊すために +1,-1する
            if (midSqu < x){
                ans = mid.toInt()
                start = mid + 1
            }else{
                end = mid - 1
            }
        }
        return ans

    }
}
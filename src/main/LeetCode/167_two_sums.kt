package main.LeetCode

class `167_two_sums` {
    fun twoSum(numbers: IntArray, target: Int): IntArray {

        val l = numbers.size-1
        val ans = IntArray(2){0}
        for (i in 0..l){
            for (j in 1..l){
                if(i==j) continue
                if (numbers[i] + numbers[j] == target){
                    ans[0] = i+1
                    ans[1] = j+1
                    return ans
                }
            }
        }
        return ans
    }
}

//binary search
fun twoSum(ar: IntArray, t: Int): IntArray {
    var l = 0
    var r = ar.lastIndex
    while (ar[l] + ar[r] != t) if (ar[l] + ar[r] > t) r-- else l++

    return intArrayOf(l + 1, r + 1)
}
package main.LeetCode

//O^2
class Solution {
    fun maxSubArray(nums: IntArray): Int {

        var maxSum = Int.MIN_VALUE
        if (nums.size == 1) return nums[0]

        for (i in nums.indices) {
            var sum = 0
            for (j in i..nums.size - 1) {
                sum += nums[j]
                maxSum = Math.max(maxSum,sum)
            }
        }
        return maxSum
    }
}


class DP {
    fun maxSubArray(nums: IntArray): Int {

        if (nums.size == 1) return nums[0]

        val dp = MutableList(nums.size){ 0 }
        var maxSum = dp[0]
        dp[0] = nums[0]

        for (i in 1..nums.size-1) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i])
        }
        return dp.maxOrNull()!!
    }
}
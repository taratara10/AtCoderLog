package main.LeetCode

class `121_best_time_to_stock_1` {
    fun maxProfit(prices: IntArray): Int {
        var ans = 0
        var min = prices[0]

        for (i in 1..prices.size-1){
            min = Math.min(min, prices[i])
            if(min != prices[i]){
                ans = Math.max(ans, prices[i]-min)
            }
        }
        return ans
    }
}
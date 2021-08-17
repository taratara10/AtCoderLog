package main.LeetCode

fun main(args:Array<String>){
    val prices = readLine()!!.split(" ").map { it.toInt() }
    var min = prices[0]
    var max = 0
    var ans = 0

    var minFlag = true

    for (i in 1..prices.size-1){

        //minを更新してbuy
        if(minFlag){
            if (prices[i] < min){
                min = prices[i]
            }else{

                minFlag = false
            }
        }

        //maxを更新してsell
        if(!minFlag){
            if(prices[i] > max){
                max = prices[i]
            }else{
                ans += max-min
                max = 0
                min = prices[i]
                minFlag = true
            }
        }

        if (i == prices.size-1 && !minFlag) ans += max-min
    }

    println(ans)

}
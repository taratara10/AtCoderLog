package main.LeetCode



    fun singleNumber(nums: IntArray): Int {
        val l = mutableListOf<Int>()

        for (i in nums){
            if (l.contains(i)){
                l.remove(i)
            }else{
                l.add(i)
            }
        }
        return l[0]
    }
package main.LeetCode

class `3_Longest_substring` {


    fun lengthOfLongestSubstring(s: String):Int {
        val str = s.toList().map { it.toString() }
        var left = 0
        var right = 1
        var ans = 0

        var l = mutableListOf<String>()

        while (right < s.length){
            if (l.contains(str[right])){
                while (s[left] != s[right]){
                    l.remove(s[left].toString())
                    left ++
                }
                right++

            }else{
                l.add(str[right])
                right ++
            }
            ans = Math.max(ans,right - left)
        }
        return ans

    }
}
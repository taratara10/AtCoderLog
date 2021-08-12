package main.LeetCode

class plusOne {
    fun plusOne(digits: IntArray): IntArray {

        val last = digits.size - 1

        //繰り上がりなし
        if (digits[last] < 9){
            digits[last] += 1
            return digits
        }

        //繰り上がり
        for (i in last downTo 0){
            if(digits[i] == 9 && i != 0){
                digits[i] = 0
            }else if(digits[i] == 9 && i == 0){
                val arr = IntArray(digits.size + 1)
                arr[0] = 1
                return arr
            }else{
                digits[i] += 1
                return digits
            }
        }
        return digits
    }

}

//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
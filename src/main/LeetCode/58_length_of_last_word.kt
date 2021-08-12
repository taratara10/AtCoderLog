
class Solution {
    fun lengthOfLastWord(s: String): Int {
        val l = s.toList()
        var count = 0

        for (i in l.size -1 downTo 0){
            if( l[i].toString() == " " && count != 0){
                break
            }else if(l[i].toString() != " " ){
                count ++
            }
        }

        return count
    }
}
package main.BeginnersSelection

fun main(args:Array<String>){
    var s = readLine()!!
    val t = listOf("dream", "dreamer", "erase", "eraser" )

    var result = true
    while (s.isNotEmpty() && result){
       when{
           s.endsWith(t[0]) -> s = s.substring(0,s.length - t[0].length )
           s.endsWith(t[1]) -> s = s.substring(0,s.length - t[1].length )
           s.endsWith(t[2]) -> s = s.substring(0,s.length - t[2].length )
           s.endsWith(t[3]) -> s = s.substring(0,s.length - t[3].length )
           else -> result = false
       }
    }
    println(if (result)"YES" else "NO")
}
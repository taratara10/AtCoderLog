
import java.util.BitSet

private typealias BitSets = List<MutableList<BitSet>>

val rx = Regex("""\s""")

fun newPuzzle(data: List<String>) {
    val rowData = data[0].split(rx)
    val colData = data[1].split(rx)
    val rows = getCandidates(rowData, colData.size)
    val cols = getCandidates(colData, rowData.size)

    val numChanged = reduceMutual(cols, rows)
    if (numChanged == -1) {
        println("No solution")
        return
    }
    while (numChanged > 0)

    // output
    for (row in rows) {
        for (i in cols.indices) {
            print(if (row[0][i]) "# " else ". ")
        }
        println()
    }
    println()
}

// collect all possible solutions for the given clues
// (example) fun ([A,B], 5) -> [false, true, false, true, true],...
fun getCandidates(data: List<String>, len: Int): BitSets {
    val result = mutableListOf<MutableList<BitSet>>()
    // convert char -> numString
    for (s in data) {
        val lst = mutableListOf<BitSet>()
        val a = s.toCharArray() // ['A','C']
        val sumChars = a.sumOf { it - 'A' + 1 }
        val prep = a.map { "1".repeat(it - 'A' + 1) } // [1,111]

        // generate numString to stringCandidates
        for (r in genSequence(prep, len - sumChars + 1)) {
            val bits = r.substring(1).toCharArray()
            val bitset = BitSet(bits.size) // All bits are initially false.
            // convert stringCandidates -> BitCandidates
            for (i in bits.indices) { bitset[i] = (bits[i] == '1') }
            lst.add(bitset)
        }
        result.add(lst)
    }
    return result
}

// fun (["1","111","1"], list.length - sumChars) 順列
fun genSequence(ones: List<String>, numZeros: Int): List<String> {
    if (ones.isEmpty()) return listOf("0".repeat(numZeros))
    val result = mutableListOf<String>()
    val canBlank = numZeros - ones.size + 2
    for (x in 1 until canBlank) {
        val skipOne = ones.drop(1) // [1,111,1] -> [11,1]
        for (tail in genSequence(skipOne, numZeros - x)) {
            result.add("0".repeat(x) + ones[0] + tail) // 0102, 0120, 0102 ...
        }
    }
    return result
}

fun reduceMutual(cols: BitSets, rows: BitSets): Int {
    val countRemoved1 = reduce(cols, rows)
    if (countRemoved1 == -1) return -1
    val countRemoved2 = reduce(rows, cols)
    if (countRemoved2 == -1) return -1
    return countRemoved1 + countRemoved2
}

fun reduce(a: BitSets, b: BitSets): Int {
    var countRemoved = 0
    for (i in 0 until a.size) {
        val commonOn = BitSet()
        commonOn[0] = b.size
        val commonOff = BitSet()

        // determine which values all candidates of a[i] have in common
        for (candidate in a[i]) {
            commonOn.and(candidate)
            commonOff.or(candidate)
        }

        // remove from b[j] all candidates that don't share the forced values
        for (j in 0 until b.size) {
            val fi = i
            val fj = j
            if (b[j].removeIf { cnd ->
                    (commonOn[fj] && !cnd[fi]) ||
                            (!commonOff[fj] && cnd[fi]) }) countRemoved++
            if (b[j].isEmpty()) return -1
        }
    }
    return countRemoved
}

val p1 = listOf("C BA CB BB F AE F A B", "AB CA AE GA E C D C")

val p2 = listOf(
    "F CAC ACAC CN AAA AABB EBB EAA ECCC HCCC",
    "D D AE CD AE A DA BBB CC AAB BAA AAB DA AAB AAA BAB AAA CD BBA DA"
)

val p3 = listOf(
    "CA BDA ACC BD CCAC CBBAC BBBBB BAABAA ABAD AABB BBH " +
            "BBBD ABBAAA CCEA AACAAB BCACC ACBH DCH ADBE ADBB DBE ECE DAA DB CC",
    "BC CAC CBAB BDD CDBDE BEBDF ADCDFA DCCFB DBCFC ABDBA BBF AAF BADB DBF " +
            "AAAAD BDG CEF CBDB BBB FC"
)

val p4 = listOf(
    "E BCB BEA BH BEK AABAF ABAC BAA BFB OD JH BADCF Q Q R AN AAN EI H G",
    "E CB BAB AAA AAA AC BB ACC ACCA AGB AIA AJ AJ " +
            "ACE AH BAF CAG DAG FAH FJ GJ ADK ABK BL CM"
)

val p5 = listOf(
    "JEF AAAAAA DAAGA AAABAA JEAA ECKA AABAAAA DAEAA AABAAA ACAAAA KGA AAABBA JAADAAA BAAAAB JAFA KGA AAAAAAA EAAAA AAAAAA KAAA",
    "MDA AABAAABAA AABAAABAA AABAAABAA ABADC AACFA ABBABA FBAF ABBABA AACAABA CGAA ABABAA ABAAA AABABAA AEDAA FF AAAAB AFAF AAAAB FAB AAF AAAA ECAC AAAA AAF"
)

fun main(args: Array<String>) {
    newPuzzle(p5)
}

//A:1
//B:2
//C:3
//D:4
//E:5
//F:6
//G:7
//H:8
//I:9
//J:10
//K:11
//L:12
//M:13
//N:14
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

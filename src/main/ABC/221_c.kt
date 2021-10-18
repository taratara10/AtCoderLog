package main.ABC

fun main(args: Array<String>) {
    val n = readLine()!!.toList()

    //2つに分けてsort 0 startは省く


    //max(ans, it)



}

private fun <T> pcSequenceFactory(
    selecteds: List<T> = emptyList(),
    filter: (options: List<T>, i: Int) -> List<T>
): (options: List<T>, k: Int) -> Sequence<List<T>> =
    { options, k ->
        sequence {
            if (k == 0) {
                yield(selecteds)
                return@sequence
            }

            options.forEachIndexed { i, option ->
                pcSequenceFactory(selecteds + option, filter).let {
                    it(filter(options, i), k - 1)
                }.forEach {
                    yield(it)
                }
            }
        }
    }

/** 重複なしの順列 */
fun <T> List<T>.permutationWithoutRepetition(k: Int): Sequence<List<T>> {
    require(k in 0..size) { "引数 k は 0 以上かつ $size 以下でなければなりません。k: $k" }

    return pcSequenceFactory<T> { options, i ->
        options.take(i) + options.drop(i + 1)
    }(this, k)
}

/** 重複なしの組み合わせ */
fun <T> List<T>.combinationWithoutRepetition(k: Int): Sequence<List<T>> {
    require(k in 0..size) { "引数 k は 0 以上かつ $size 以下でなければなりません。k: $k" }

    return pcSequenceFactory<T> { options, i ->
        options.drop(i + 1)
    }(this, k)
}

/** 重複ありの順列 */
fun <T> List<T>.permutationWithRepetition(k: Int): Sequence<List<T>> {
    require(k >= 0) { "引数 k は 0 以上でなければなりません。k: $k" }

    return pcSequenceFactory<T> { options, i ->
        options
    }(this, k)
}

/** 重複ありの組み合わせ */
fun <T> List<T>.combinationWithRepetition(k: Int): Sequence<List<T>> {
    require(k >= 0) { "引数 k は 0 以上でなければなりません。k: $k" }

    return pcSequenceFactory<T> { options, i ->
        options.drop(i)
    }(this, k)
}
package l_lambdas

fun main() {

    val names = arrayOf("ZZZZZZ", "BB", "A", "CCCC", "EEEEE")
    println(names.sorted())
    val namesByLength = names.sortedWith(compareBy {
        -it.length // pay attention to the - : the minus sign causes the sort to be descending by length
    })
    println(namesByLength.joinToString())
}
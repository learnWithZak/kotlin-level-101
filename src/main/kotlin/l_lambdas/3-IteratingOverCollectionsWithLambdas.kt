package l_lambdas

fun main() {

    val values = listOf(1,2,3,4,5,6)
    values.forEach {
        println("$it : ${it * it}")
    }

    var prices = listOf(1.5, 10.0, 4.99, 2.30, 8.19)
    val largePrices = prices.filter {
        it > 5.0
    }
    println(largePrices.joinToString())

    val salePrices = prices.map {
        it * 0.9
    }
    println(salePrices)

    val userInput = listOf("0", "11", "haha", "42")
    val numbers = userInput.map {
        it.toIntOrNull()
    }
    println(numbers)
    val numbers2 = userInput.mapNotNull {
        it.toIntOrNull()
    }
    println(numbers2)

    val data = listOf(1,2,2,2)
    var sum = data.fold(initial = 0.0) { a, b ->
        println("a = $a")
        println("b = $b")
        a + b
    }
    println(sum)

    // reduce uses the 1st element as the starting value
    sum = data.reduce {acc, d ->
        acc + d
    }.toDouble()
    println(sum)

    val stock = mapOf(
        1.5 to 5,
        10.0 to 2,
        4.99 to 20,
        2.30 to 5,
        8.19 to 30
    )
    var stockSum = 0.0
    stock.forEach {
        stockSum += it.key * it.value
    }
    println(stockSum)

    /**
     * Mini-exercises
     */
    val nameList = listOf("AAAAAA", "BBB", "CCC", "DDDDDD", "EE")
    var concatenated = nameList.fold("") { acc: String, s: String ->
        acc + s
    }
    println(concatenated)

    concatenated = nameList.filter {
        it.length > 4
    }.fold("") { acc: String, s: String ->
        acc + s
    }
    println(concatenated)

    val namesAndAges = mapOf(
        "Zak" to 26,
        "Greek" to 31,
        "Toto" to 17
    )
    val newList = namesAndAges.filter {
        it.value < 18
    }.map {
        it.key
    }
    println(newList)

    /**
     * Challenges
     */

    fun repeatTask(times: Int, action: () -> Unit) {
        for(i in 0 until times) {
            action()
        }
    }

    repeatTask(10) {
        println("Kotlin is a great language!")
    }

    fun mathSum(length: Int, series: (Int) -> Int): Int {
        var result = 0
        for (i in 1 .. length) {
            result += series(i)
        }
        return result
    }

    val squares = mathSum(10) {
        it * it
    }
    println(squares)

    fun fib(number: Int): Int {
        if (number <= 0) return 0
        if (number == 1 || number == 2) return 1
        return fib (number - 1) + fib(number - 2)
    }

    val fib = mathSum(10, ::fib)
    println(fib)


    val appRatings = mapOf(
        "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
        "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
        "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
    )

    val averageRatings = mutableMapOf<String, Double>()

    appRatings.forEach {
        val total = it.value.reduce { acc, i ->
            (acc + i)
        }
        averageRatings[it.key] = total.toDouble() / it.value.size
    }
    println(averageRatings)

    val greaterThanThree = averageRatings.filter {
        it.value > 3
    }.map {
        it.key
    }
    println(greaterThanThree)
}
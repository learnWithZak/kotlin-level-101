package p_methods

import kotlin.math.PI

fun main() {
    val months = arrayOf(
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"
    )

    class SimpleDate(var month: String)

    fun monthsUntilWinterBreak(from: SimpleDate): Int {
        return months.indexOf("December") - months.indexOf(from.month)
    }

    println(monthsUntilWinterBreak(SimpleDate("September")))

    // OTHER WAY
    class SimpleDate2(var month: String) {
        fun monthsUntilWinterBreak(from: SimpleDate2): Int {
            return months.indexOf("December") - months.indexOf(from.month)
        }
    }

    val date2 = SimpleDate2("September")
    println(date2.monthsUntilWinterBreak(date2))

    /**
     * Introducing this
     */
    class SimpleDate3(var month: String) {
        fun monthsUntilWinterBreak(): Int {
            return months.indexOf("December") - months.indexOf(this.month) // you can remove 'this'
        }
    }

    val date3 = SimpleDate3("September")
    println(date3.monthsUntilWinterBreak())

    /**
     * Mini-exercise
     */

    class SimpleDate4(var month: String) {
        val monthsUntilWinterBreak: Int
            get() = months.indexOf("December") - months.indexOf(month)
    }

    val date4 = SimpleDate4("September")
    println(date4.monthsUntilWinterBreak)

    /**
     * Object methods
     */
    println(MyMath.factorial(6))

    /**
     * Mini-exercise
     */
    println(MyMath.triangle(5))

    /**
     * Extension methods
     */
    fun SimpleDate.monthsUntilSummerBreak(): Int {
        return when (months.indexOf(month)) {
            in 0..months.indexOf("June") -> {
                months.indexOf("June") - months.indexOf(month)
            }
            in months.indexOf("June")..months.indexOf("August") -> {
                0
            }
            else -> {
                months.indexOf("June") + (12 - months.indexOf(month))
            }
        }
    }

    val date = SimpleDate("December")
    println(date.monthsUntilSummerBreak())

    fun Int.abs(): Int {
        return if (this < 0) -this else this
    }

    println(3.abs())
    println((-3).abs())

    /**
     * Companion object
     */

    fun MyMath.Companion.primeFactors(value: Int): MutableList<Int> {
        var remainingValue = value
        var testFactor = 2
        val primes = mutableListOf<Int>()
        while (testFactor * testFactor <= remainingValue) {
            if (remainingValue % testFactor == 0) {
                primes.add(testFactor)
                remainingValue /= testFactor
            } else {
                testFactor += 1
            }
        }
        if (remainingValue > 1) {
            primes.add(remainingValue)
        }
        return primes
    }

    println(MyMath.primeFactors(81))

    /**
     * Challenges
     */
    class Circle(var radius: Double = 0.0) {
        val area: Double
            get() {
                return PI * radius * radius
            }

        fun grow(factor: Int): Double {
            return area * factor
        }
    }
    val circle = Circle(2.0)
    println(circle.area)
    println(circle.grow(factor = 2))

    class SimpleDate5(var month: String, var day: Int = 0) {
        val daysOfMonth: Int
            get() {
                return when (month) {
                    "January", "March", "May", "July", "August", "October", "December" -> 31
                    "April", "June", "September", "November" -> 30
                    "February" -> 28
                    else -> 0
                }
            }

        fun advance() {
            if (daysOfMonth == 31 || daysOfMonth == 30 || daysOfMonth == 28) {
                day = 1
            } else {
                day += 1
            }

            month = if (month == "December") "January" else months[months.indexOf(month) + 1]
        }
    }
    val date5 = SimpleDate5(month = "December", day = 31)
    date5.advance()
    println(date5.month)
    println(date5.day)

    println(MyMath2.isEven(2))
    println(MyMath2.isOdd(2))

    fun Int.isEven(number: Int) = MyMath2.isEven(number)
    fun Int.isOdd(number: Int) = MyMath2.isOdd(number)
    fun Int.primeFactors(number: Int) = MyMath.primeFactors(number)
}

/**
 * Object methods
 */
class MyMath {
    companion object {
        fun factorial(number: Int): Int {
            return (1..number).reduce { acc, i ->
                acc * i
            }
        }
        fun triangle(number: Int): Int {
            return (1..number).reduce { acc, i ->
                acc + i
            }
        }
    }
}

object MyMath2 {
    fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    fun isOdd(number: Int): Boolean = !isEven(number)
}
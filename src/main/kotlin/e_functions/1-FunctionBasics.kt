package e_functions

import kotlin.math.sqrt

fun main() {
    printMyName()
}
fun printMyName() {
    println("My name is Zakaria Afir.")
    printMultipleOfFive(10) // 10 is called argument
    printMultipleOf(10, 5)

    /**
     * Parameter named arguments
     */
    printMultipleOf(multiplier = 4, andValue = 5)

    printFullName(firstName = "John", lastName = "Doe")

    val calculatedFullName = calculateFullName("Zakaria", "Afir")
    println("my full name (${calculatedFullName.first}) length is: ${calculatedFullName.second}")

    var function: (Int, Int) -> Int = ::add
    println(function(2, 5))
    function = ::subtract
    println(function(2, 5))

    printResult(::add, 2, 5)

    println(isPrime(6)) // false
    println(isPrime(13)) // true
    println(isPrime(8893)) // true

    println(fibonacci(1))  // = 1
    println(fibonacci(2))  // = 1
    println(fibonacci(3))  // = 2
    println(fibonacci(4))  // = 3
    println(fibonacci(5))  // = 5
    println(fibonacci(6))  // = 8
    println(fibonacci(7))  // = 13
    println(fibonacci(10)) // = 55

}

/**
 * function parameters
 */

// `value` is called parameter
fun printMultipleOfFive(value: Int) {
    println(value * 5)
}

fun printMultipleOf(multiplier: Int, andValue: Int) {
    println(multiplier * andValue)
}

/**
 * Parameter default values
 */

fun printlnMultipleOfWithDefault(multiplier: Int, value: Int = 1) {
    println(multiplier * value)
}

/**
 * Return values
 */
fun multiply(number: Int, multiplier: Int): Int {
    return number * multiplier
}
fun multiplyAndDivide(number: Int, factor: Int): Pair<Int, Int> {
    return Pair(number * factor, number / factor)
}
fun multiplyInferred(number: Int, multiplier: Int) = number * multiplier

/**
 * Parameters as values
 */
fun incrementAndPrint(value: Int) {
    //value += 1 // Val cannot be reassigned
    println(value)
}

// if you want to change indirectly a parameter, you can use:

fun incrementAndPrintChanged(value: Int): Int {
    val newValue = value + 1
    println(newValue)
    return newValue
}

/**
 * Overloading: more than one function with the same name
 */

fun getValue(value: Int): Int {
    return value + 1
}

// this is an error, the return type is not enough to distinguish two functions

//fun getValue(value: Int): Double {
    //return (value + 1).toDouble()
//}

fun getValue(value: String): String {
    return "the value is $value"
}

/**
 * Mini exercises
 */

fun printFullName(firstName: String, lastName: String) {
    println("$firstName $lastName")
}

fun calculateFullName(firstName: String, lastName: String): Pair<String, Int> {
    val fullName = "$firstName $lastName"
    return fullName to fullName.length
}

/**
 * Functions as variables
 */

fun add(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun printResult(function: (Int, Int) -> Int, a: Int, b: Int) {
    val result = function(a, b)
    println(result)
}

/**
 * Challenges
 */

// 1 - it's prime time
fun isNumberDivisible(number: Int, divisor: Int): Boolean {
    return number % divisor == 0
}

fun isPrime(number: Int): Boolean {
    if (number <= 0)
        return false

    if (number <= 3)
        return true

    for (counter in 2 .. sqrt(number.toDouble()).toInt()) {
        if (isNumberDivisible(number, counter)) {
            return false
        }
    }
    return true
}

// 2 - recursive functions
fun fibonacci(number: Int): Int {
    if (number <= 0) return 0
    if (number == 1 || number == 2) return 1
    return fibonacci(number - 1) + fibonacci(number - 2)
}
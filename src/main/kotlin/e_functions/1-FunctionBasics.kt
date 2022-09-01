package e_functions

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

    var function = ::add
    println(function.invoke(2, 5))
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
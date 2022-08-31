package d_advancedControlFlow

fun main() {
    val number = 10
    when (number) {
        0 -> println("Zero")
        10 -> println("it's ten") //unlike java, there is no need to include break
        else -> println("Non-zero")
    }

    val string = "Dog"
    when (string) {
        "Cat", "Dog" -> println("Animal is a house pet.")
        else -> println("Animal is not a house pet.")
    }

    /**
     * Returning value
     */
    val numberName = when (number) {
        2 -> "two"
        4 -> "four"
        6 -> "six"
        8 -> "eight"
        10 -> "ten"
        else -> {
            println("Unknown number")
            "Unknown"
        }
    }
    println(numberName)

    /**
     * Advanced when expressions
     */

    val hourOfDay = 12
    var timeOfDay: String

    timeOfDay = when (hourOfDay) {
        0, 1, 2, 3, 4, 5 -> "Early morning"
        6, 7, 8, 9, 10, 11 -> "Morning"
        12, 13, 14, 15, 16 -> "Afternoon"
        17, 18, 19 -> "Evening"
        20, 21, 22, 23 -> "Late evening"
        else -> "INVALID HOUR"
    }
    println(timeOfDay)

    // OR

    timeOfDay = when (hourOfDay) {
        in 0..5 -> "Early morning"
        in 6..11 -> "Morning"
        in 12..16 -> "Afternoon"
        in 17..19 -> "Evening"
        in 20..23 -> "Late evening"
        else -> "INVALID HOUR"
    }
    println(timeOfDay)

    /**
     * Using when expressions with conditions
     */

    when {
        number % 2 == 0 -> println("Even")
        else -> println("Odd")
    }

    val (x, y, z) = Triple(3,2,5)
    when {
        x == 0 && y == 0 && z == 0 -> println("Origin")
        y == 0 && z == 0 -> println("On the x-axis at x = $x")
        x == 0 && z == 0 -> println("On the y-axis at y = $y")
        x == 0 && y == 0 -> println("On the z-axis at z = $z")
        x == y -> println("Along the y = x line")
        y == x * x -> println("Along the y = x^2 line")
        else -> println("In space at x = $x, y = $y, z = $z")
    }

    /**
     * Mini-exercise
     */

    val age = 5
    when (age) {
        in 0..2 -> "Infant"
        in 3..12 -> "Child"
        in 13..19 -> "Teenager"
        in 20..39 -> "Adult"
        in 40..60 -> "Middle age"
        in 61..Int.MAX_VALUE -> "Elderly"
        else -> "Invalid"
    }

    val pair = "toto" to 22
    val lifeStage = when (pair.second) {
        in 0..2 -> "Infant"
        in 3..12 -> "Child"
        in 13..19 -> "Teenager"
        in 20..39 -> "Adult"
        in 40..60 -> "Middle age"
        in 61..Int.MAX_VALUE -> "Elderly"
        else -> "Invalid"
    }
    println("${pair.first} is $lifeStage")
}
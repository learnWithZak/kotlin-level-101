package c_basicControlFlow

fun main() {
    if (2 > 1) {
        println("Yes, 2 is greater than 1")
    }

    /**
     * The else expression
     */
    val animal = "Fox"

    if (animal == "Cat" || animal == "Dog") {
        println("Animal is a house pet.")
    } else {
        println("Animal is not a house pet.")
    }

    val a = 5
    val b = 10

    val min: Int
    if (a < b) {
        min = a
    } else {
        min = b
    }

    val max: Int
    if (a > b) {
        max = a
    } else {
        max = b
    }

    println(min)
    println(max)

    println("Or we can write it in a more concise way")

    val a2 = 5
    val b2 = 10
    val min2 = if (a2 < b2) a2 else b2
    val max2 = if (a2 > b2) a2 else b2
    println(min2)
    println(max2)

    /**
     * The else-if expression (THE ORDER MATTERS)
     */
    val hourOfDay = 12
    val timeOfDay = if (hourOfDay < 6) {
        "Early morning"
    } else if (hourOfDay < 12) {
        "Morning"
    } else if (hourOfDay < 17) {
        "Afternoon"
    } else if (hourOfDay < 20) {
        "Evening"
    } else if (hourOfDay < 24) {
        "Late evening"
    } else {
        "INVALID HOUR!"
    }

    println(timeOfDay)
}
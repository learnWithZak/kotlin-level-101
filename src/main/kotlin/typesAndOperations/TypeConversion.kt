package typesAndOperations

fun main() {
    var integer: Int = 100
    var decimal: Double = 12.5
    // integer = decimal // Kotlin will complain
    integer = decimal.toInt()
    println(integer) // loose of precision from 12.5 to 12

    /**
     * Operators with mixed types
     */

    val hourlyRate: Double = 19.5
    val hoursWorked: Int = 10
    val totalCost: Double = hourlyRate * hoursWorked
    println(totalCost)

    /**
     * Type inference
     */
    val typeInferredInt = 42
    val typeInferredDouble = 3.14159

    val wantADouble = 3
    val actuallyDouble = 3.toDouble()
    val actuallyAlsoDouble: Double = 3.0

    /**
     * Mini-exercise
     */
    val age1 = 42.0
    val age2 = 21.0
    val avg1 = (age1 + age2) / 2
    println(avg1)
}
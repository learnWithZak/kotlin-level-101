package b_typesAndOperations

import kotlin.math.PI

fun main() {
    val coordinates = 2 to 3
    val (row, column) = coordinates

    val a = 4
    val b: Short = 100
    val c: Byte = 12
    val result = a + b - c // Int
    println(result)

    println(PI)
    println(PI.toFloat())
}
package d_advancedControlFlow

import kotlin.math.sqrt

fun main() {
    val count = 10
    var sum = 0
    for (i in 1..count) {
        sum += i
    }
    println("sum is $sum")

    /**
     * Repeat loops
     */
    sum = 1
    var lastSum = 0
    repeat(10) {
        val temp = sum
        sum += lastSum
        lastSum = temp
        println("tmp = $temp / sum = $sum / lastSum = $lastSum")
    }

    /**
     * Steps in loops
     */
    sum = 0
    for (i in 1..count step 2) {
        sum += i
    }

    sum = 0
    for (i in count downTo 1 step 2) {
        sum += i
    }

    /**
     * labeled statements
     */
    for (i in 0..7) {
        for (j in 0 .. 7) {
            if (i % 2 == 0) continue
            print("${i * j} ")
        }
        println()
    }

    println("-------")
    for (row in 0..7) {
        for (column in 0 .. 7) {
            if (column >= row) break
            print("${row * column} ")
        }
        println()
    }


    /**
     * Mini-exercises
     */
    println("---------")
    val range = 1..10
    for(i in range) {
        println(i * i)
    }

    println("------")
    for (i in range) {
        println(sqrt(i.toFloat()))
    }

    println("------------")
    sum = 0
    for (row in 1 until 8 step 2) {
        for (column in 0 until 8) {
            sum += row * column
            println(sum)
        }
    }
}
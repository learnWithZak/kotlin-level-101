package c_basicControlFlow

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    /**
     * While loops
     */

    var sum = 1
    while (sum < 1000) {
        sum += (sum + 1)
        println(sum)
    }

    /**
     * Repeat-while loops
     */
    sum = 1
    do {
        sum += (sum + 1)
        println(sum)
    } while (sum < 1000)

    println("----------")
    sum = 1
    while (sum < 1) {
        sum += (sum + 1)
        println(sum)
    }
    println("----------")
    sum = 1
    do {
        sum += (sum + 1)
        println(sum)
    } while (sum < 1)

    /**
     * Breaking out of a loop
     */
    println("----------")
    sum = 1
    while (true) {
        sum += (sum + 1)
        println(sum)
        if (sum >= 1000) {
            break
        }
    }

    /**
     * Mini-exercises
     */
    var counter = 0
    while (counter < 10) {
        println("counter is $counter")
        counter++
    }
    println("-------------")
    counter = 0
    var roll = 0
    do {
     roll = Random().nextInt(6)
     counter++
     println("After $counter rolls, roll is $roll")
    } while (roll != 0)

    /**
     * Challenges
     */
    val answer1 = true && true
    val answer2 = false || false
    val answer3 = (true && 1 != 2) || (4 > 3 && 100 < 1)
    val answer4 = ((10 / 2) > 3) && ((10 % 2) == 0)

    println(answer1)
    println(answer2)
    println(answer3)
    println(answer4)

    println("---------")
    var currentRow = 7
    var currentColumn = 7
    var nextRow = 0
    var nextColumn = 0

    println("current row: $currentRow")
    println("current column: $currentColumn")
    while (currentRow >= 0 && currentRow <= 7) {
        while (currentColumn >= 0 && currentColumn <= 7) {
            nextColumn = currentColumn + 1
            if (nextColumn > 7) {
                currentRow += 1
                if (currentRow > 7) {
                    currentRow = 0
                }
                nextColumn = 0
            }
            nextRow = currentRow
            break
        }
        break
    }
    println("next row: $nextRow")
    println("next column: $nextColumn")

    println("-------------")
    val row = 7
    val column = 7

    var nextRow2 = row
    var nextColumn2 = column + 1
    if (nextColumn2 > 7) {
        nextColumn2 = 0
        nextRow2 += 1
    }
    if (nextRow2 > 7) {
        nextRow2 = 0
    }
    println("The position after ($row, $column) is ($nextRow2, $nextColumn2)")

    println("----------Quadratic formula")

    val a = 1
    val b = -5.0
    val c = 6

    val delta = (b * b) - (4 * a * c)

    if (delta > 0) {
        val x1 = -b + sqrt(delta) / (2 * a)
        val x2 = -b - sqrt(delta) / (2 * a)

        println("x1 = $x1")
        println("x2 = $x2")
    } else if (delta == 0.0) {
        val x = -b / (2 * a)
        println("x = $x")
    } else {
        println("complex num")
    }

    println("--------------")
    val month = "february"
    val currentYear = 2022
    var days = 0

    if (month == "january" || month == "march" || month == "may" || month == "july" || month == "august" ||
        month == "october" || month == "december") {
        days = 31
    } else if (month == "april" || month == "june" || month == "september" || month == "november") {
        days = 30
    }
    else if (month == "february" && (currentYear % 4 == 0 && currentYear % 100 != 0) || (currentYear % 400 == 0)) {
        days = 29
    } else if (month == "february"){
        days = 28
    }
    println("$month in $currentYear has $days days")

    println("-------------")
    val number = 1024.0
    if (number % 2.0 == 0.0) {
        println("$number is a power of 2")
    } else {
        println("$number is not a power of 2")
    }

    println("-----------")
    var powers = 0
    while (powers <= 10) {
        println(powers * 2)
        powers ++
    }

    println("-----------fib--------")
    val fibNumber = 10
    var current = 1
    var previous = 1
    var done = 2
    while (done < fibNumber) {
        val next = current + previous
        previous = current
        current = next
        done += 1
    }
    println("fibonacci total: $current")

    println("------fact")

    val target = 4
    var factCounter = 1
    var total = 1
    while (factCounter <= target) {
        total *= factCounter
        factCounter ++
    }
    println("factorial of $target is $total")
}
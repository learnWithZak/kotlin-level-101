package v_functional_programming

import java.util.Random
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val firstRobot = Robot("Experimental Space Navigation Droid")
    val secondRobot = Robot("Extra-Terrestrial Air Safety Droid")

    Battlefield.beginBattle(firstRobot, secondRobot, ::onBattleFinished)
    println(pow(2, 4))

    val onBattleFinished = { winner: Robot -> winner.report("Win!")}
    Battlefield.beginBattle(firstRobot, secondRobot, onBattleFinished)

    Battlefield.beginBattle(firstRobot, secondRobot) {
        report("Win!")
    }

    sum(5, 19)
    sum(1, 2)

    val string = "Hello!"
    string.print()

    /**
     * Anonymous functions
     */

    val reportOnWin = fun(robot: Robot) {
        robot.report("Win!")
    }

    Battlefield.beginBattle(firstRobot, secondRobot, reportOnWin)
    Battlefield.beginBattle(firstRobot, secondRobot, fun(robot) {
        robot.report("Win!")
    })

}

/**
 * Lambdas
 */
fun onBattleFinished(winner: Robot) {
    winner.report("Win!")
}

fun someFunction(): () -> Int {
    return ::anotherFunction
}

fun anotherFunction(): Int {
    return Random().nextInt()
}

val pow = { base: Int, exponent: Int ->
    base.toDouble().pow(exponent.toDouble())
}

val pow2: (Int, Int) -> Double = { base, exponent ->
    base.toDouble().pow(exponent.toDouble())
}

val root: (Int) -> Double = {
    sqrt(it.toDouble())
}

/**
 * Closures
 */

var result = 0
val sum = { a: Int, b: Int ->
    result = a + b
    println(result)
}

/**
 * Extension function
 */

fun String.print() = System.out.println(this)
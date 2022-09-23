package v_functional_programming

import java.util.Random

fun main() {
    val firstRobot = Robot("Experimental Space Navigation Droid")
    val secondRobot = Robot("Extra-Terrestrial Air Safety Droid")

    Battlefield.beginBattle(firstRobot, secondRobot, ::onBattleFinished)

}

fun onBattleFinished(winner: Robot) {
    winner.report("Win!")
}

fun someFunction(): () -> Int {
    return ::anotherFunction
}

fun anotherFunction(): Int {
    return Random().nextInt()
}
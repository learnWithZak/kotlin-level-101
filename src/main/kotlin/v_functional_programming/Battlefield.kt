package v_functional_programming

object Battlefield {
    fun beginBattle(firstRobot: Robot, secondRobot: Robot) {
        var winner: Robot? = null
        battle(firstRobot, secondRobot)

        winner = if (firstRobot.isAlive) firstRobot else secondRobot
    }

    private fun battle(firstRobot: Robot, secondRobot: Robot) {
        firstRobot.attack(secondRobot)
        if (secondRobot.isAlive.not()) {
            return
        }

        secondRobot.attack(firstRobot)
        if (firstRobot.isAlive.not()) {
            return
        }

        battle(firstRobot, secondRobot)
    }
}
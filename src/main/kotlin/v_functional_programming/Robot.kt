package v_functional_programming

import java.util.Random

class Robot(val name: String) {
    var strength: Int = 0
    private var health: Int = 100
    var isAlive = true

    init {
        strength = Random().nextInt(100) + 10
        report("Created (strength $strength)")
    }

    fun report(message: String) {
        println("$name: \t$message")
    }

    private fun damage(damage: Int) {
        val blocked = Random().nextBoolean()

        if (blocked) {
            report("Blocked attack")
            return
        }

        health -= damage
        report("Damage -$damage, health $health")

        if (health <= 0) {
            isAlive = false
        }
    }

    fun attack(robot: Robot) {
        val damage = (strength * 0.1 + Random().nextInt(10)).toInt()
        robot.damage(damage)
    }
}
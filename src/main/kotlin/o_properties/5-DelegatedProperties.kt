package o_properties

import kotlin.math.atan
import kotlin.properties.Delegates

fun main() {
    /**
     * Observable properties
     */
    val delegatedLevel1 = DelegatedLevel(id = 1, boss = "Chameleon")
    val delegatedLevel2 = DelegatedLevel(id = 2, boss = "Squid")

    println(DelegatedLevel.highestLevel)

    delegatedLevel2.unlocked = true

    println(DelegatedLevel.highestLevel)

    /**
     * Limiting a variable
     */

    println("---------")
    val light = LightBulb()
    light.current = 50
    println(light.current)
    light.current = 39
    println(light.current)
    light.current = 70
    println(light.current)

    /**
     * Lazy properties
     */

    println("---------")
    val circle = Circle(5.0)
    println(circle.circumference)
    circle.radius = 2.0
    println(circle.circumference)
}

class DelegatedLevel(val id: Int, var boss: String) {

    companion object {
        var highestLevel = 1
    }

    var unlocked: Boolean by Delegates.observable(false) {
        _, old, new ->
        if (new && id > highestLevel) {
            highestLevel = id
        }
        println("$old -> $new")
    }
}

class LightBulb {

    companion object {
        const val maxCurrent = 40
    }

    var current: Int by Delegates.vetoable(0) {
        _, _, new ->
        if (new > maxCurrent) {
            println("Current too high, falling back to previous setting.")
            false
        } else {
            true
        }
    }
}
class Circle(var radius: Double = 0.0) {
    val pi: Double by lazy {
        ((4.0 * atan(1.0 / 5.0)) - atan(1.0 / 239.0)) * 4.0
    }
    val circumference: Double
        get() = pi * radius * 2
}
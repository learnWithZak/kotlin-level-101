package o_properties

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
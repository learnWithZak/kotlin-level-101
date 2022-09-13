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
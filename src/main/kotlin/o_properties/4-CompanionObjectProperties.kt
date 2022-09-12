package o_properties

class Level(
    val id: Int,
    var boss: String,
    var unlocked: Boolean
) {
    companion object {
        var highestLevel = 1
        @JvmStatic var highestLevelForJavaTest = 1
    }

    val level1 = Level(id = 1, boss = "Chameleon", unlocked = true)
    val level2 = Level(id = 2, boss = "Squid", unlocked = false)
    val level3 = Level(id = 3, boss = "Chupacabra", unlocked = false)
    val level4 = Level(id = 4, boss = "Yeti", unlocked = false)
}

fun main() {
    val highestLevel = Level.highestLevel
}
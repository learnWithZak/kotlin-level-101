package k_mapsAndSets

fun main() {
    val map1 = mutableMapOf(
        "NY" to "New York",
        "CA" to "California"
    )

    fun printStatesLongerThanEightCharacters(map: Map<String, String>) {
        for (state in map.values) {
            if (state.length > 8) {
                println(state)
            }
        }
    }

    printStatesLongerThanEightCharacters(map1)

    fun mergeMaps(
        map1: Map<String, String>,
        map2: Map<String, String>
    ): Map<String, String> {
        val mergedMap = mutableMapOf<String, String>()
        mergedMap.putAll(map1)
        mergedMap.putAll(map2)
        return mergedMap
    }

    val firstMap = mapOf("1" to "2", "2" to "2")
    val secondMap = mapOf("1" to "1", "3" to "3")
    println(mergeMaps(firstMap, secondMap))

    fun occurrencesOfCharacters(text: String): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        for (character in text) {
            map[character] = map.getOrDefault(character, defaultValue = 0) + 1
        }
        return map
    }

    println(occurrencesOfCharacters("AZERAKA"))

    fun isInvertible(map: Map<String, Int>): Boolean {
        var array = IntArray(map.size)
        for (element in map.values) {
            if (array.contains(element)) {
                return false
            } else {
                array += element
            }
        }
        return true
    }

    val invertibleMap = mapOf("1" to 1, "2" to 2, "3" to 3)
    println(isInvertible(invertibleMap))

    val nonInvertibleMap = mapOf("1" to 3, "2" to 2, "3" to 3)
    println(isInvertible(nonInvertibleMap))

    val nameTitleLookup: Map<String, String?> = mutableMapOf(
        "Mary" to "Engineer",
        "Patrick" to "Intern",
        "Ray" to "Hacker"
    )

    val newMap = nameTitleLookup.toMutableMap()
    newMap["Patrick"] = null
    newMap.remove("Ray")
    println(newMap)
}
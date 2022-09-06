package k_mapsAndSets

fun main() {

    /**
     * Using the index operator
     */
    var namesAndScores = mutableMapOf(
        "Anna" to 2,
        "Brian" to 2,
        "Craig" to 8,
        "Dinna" to 6
    )

    println(namesAndScores["Anna"])
    println(namesAndScores["Zak"])

    /**
     * Using properties and methods
     */
    println(namesAndScores.get("Craig"))
    println(namesAndScores.isEmpty())
    println(namesAndScores.size)
}
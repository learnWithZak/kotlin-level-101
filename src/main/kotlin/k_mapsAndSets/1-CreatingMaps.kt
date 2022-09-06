package k_mapsAndSets

fun main() {

    /**
     * Creating maps
     */
    var yearOfBirth = mapOf(
        "Anna" to 1990,
        "Brian" to 1991,
        "Craig" to 1992,
        "Donna" to 1993
    )

    // Maps are not guaranteed to be ordered
    var namesAndScores = mutableMapOf(
        "Anna" to 2,
        "Brian" to 2,
        "Craig" to 8,
        "Dinna" to 6
    )
    println(namesAndScores)

    namesAndScores = mutableMapOf()

    var pairs = HashMap<String, Int>()
    pairs = HashMap(20)
}
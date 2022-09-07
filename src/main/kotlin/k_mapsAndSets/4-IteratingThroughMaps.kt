package k_mapsAndSets

fun main() {
    // you need to use destructuring declaration to iterate over a map
    var namesAndScores = mutableMapOf(
        "Anna" to 2,
        "Brian" to 2,
        "Craig" to 8,
        "Dinna" to 6
    )

    for ((name, score) in namesAndScores) {
        println("$name - $score")
    }

    for (key in namesAndScores.keys) {
        print("$key, ")
    }
}
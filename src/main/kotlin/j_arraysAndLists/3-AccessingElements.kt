package j_arraysAndLists

fun main() {

    /**
     * Using properties and methods
     */

    val players = mutableListOf("Alice", "Bob", "Zak", "Alex")
    println(players.isEmpty())
    if (players.size >= 2) {
        println("let's start the game")
    } else {
        println("We need at least 2 players")
    }

    val currentPlayer = players.first()
    println(currentPlayer)

    println(players.last())

    val minPlayer = players.minOrNull()
    minPlayer?.let {
        println("$minPlayer will start") // Alice (the lowest in alphabetical order)
    }

    println(arrayOf(2, 3, 1).first())
    println(arrayOf(2, 3, 1).min())

    val maxPlayer = players.maxOrNull()
    maxPlayer?.let {
        println("$maxPlayer is the MAX")
    }

    /**
     * Using indexing
     */
    val firstPlayer = players[0]
    println("First player is $firstPlayer")
    val secondPlayer = players.get(1)
    println("2nd player is $secondPlayer")
    // val unfoundedPlayer = players[55]
    // println("unfounded: $unfoundedPlayer") // IndexOutOfBoundsException error

    /**
     * Using ranges to slice
     */
    // to get the next 2 players
    val upcomingPlayersSlice = players.slice(1..2)
    println(upcomingPlayersSlice.joinToString())

    /**
     * Checking for an element
     */
    fun isEliminated(player: String): Boolean {
        return player !in players
    }

    println(isEliminated("Bob"))
    println(isEliminated("Toto"))

    val combineSliceWithContains = players.slice(1..3).contains("Alice")
    println(combineSliceWithContains)
}
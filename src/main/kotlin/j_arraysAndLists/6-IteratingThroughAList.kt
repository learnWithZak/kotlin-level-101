package j_arraysAndLists

fun main() {
    val scores = listOf(2,2,8,6,1)

    players.add("Frankin")
    for (player in players) {
        println(player)
    }

    for((index, player) in players.withIndex()) {
        println("${index + 1}. $player")
    }

    fun sumOfElements(list: List<Int>): Int {
        var sum = 0
        for (number in list) {
            sum += number
        }
        return sum
    }

    println(sumOfElements(scores))

    /**
     * mini-exercise
     */
    fun writePlayersAndScores(players: List<String>, scores: List<Int>) {
        if (players.size != scores.size) {
            println("An error")
        } else {
            for ( (index, player) in players.withIndex()) {
                println("the player $player has the score: ${scores[index]}")
            }
        }
    }

    writePlayersAndScores(players, scores)
}
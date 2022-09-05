package j_arraysAndLists

fun main() {
    players.add("Eli")
    players += "Gina"
    players.add(5, "Frank")
    players.remove("Gina")
    players.remove("Cindy")

    println(players.joinToString())
    players[4] = "Frankin"
    println(players.joinToString())

    players[3] = "Anna" // players.set(3, "Anna")
    players.sort()
    println(players.joinToString())

    val arrayOfInts = arrayOf(1, 2, 3)
    arrayOfInts[0] = 4
    println(arrayOfInts.joinToString())
}
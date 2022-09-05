package j_arraysAndLists

fun main() {
    /**
     * Appending elements
     */
    players.add("Eli")
    players += "Gina"

    var array = arrayOf(1,2,3)
    array += 4 // you are not appending the value onto the array, you are creating a new array and assign it to the original variable
    println(array.joinToString())

    /**
     * Inserting elements
     */
    players.add(5, "Frank")

    /**
     * Removing elements
     */
    val wasPlayerRemoved = players.remove("Gina")
    println("It is $wasPlayerRemoved that Gina was removed")

    val removedPlayer = players.removeAt(2)
    println("$removedPlayer was removed")

    /**
     * Mini-exercise
     */
    val indexOfDan = players.indexOf("Dan")
    println("Dan is at the index $indexOfDan")
}
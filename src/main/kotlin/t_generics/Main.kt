package t_generics

fun <T> List<T>.toBulletedList(): String {
    val separator = "\n - "
    return this.joinToString(prefix = separator, separator = separator, postfix = "\n") { "$it" }
}

class Mover<T>(thingsToMove: List<T>, val truckHeightInInches: Int = (12 * 12)) {
    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingsInTrack = mutableListOf<T>()
    private var thingsInNewPlace = mutableListOf<T>()

    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    fun moveEverythingToTruck() {
        while (thingsLeftInOldPlace.isNotEmpty()) {
            val item = thingsLeftInOldPlace.removeAt(0)
            thingsInTrack.add(item)
            println("Moved your $item to the truck")
        }
    }

    fun moveEverythingIntoNewPlace() {
        while (thingsInTrack.isNotEmpty()) {
            val item = thingsInTrack.removeAt(0)
            thingsInNewPlace.add(item)
            println("Moved your $item into your new place")
        }
    }

    fun finishMove() {
        println("OK, we finished! We moved to the new place the items:${thingsInNewPlace.toBulletedList()}")
    }
}
fun main() {
    val names = listOf("Bob", "Carol", "Ted", "Alice")
    println("Names: ${names.toBulletedList()}")
    val firstName = names.first()
    println(firstName)
    // val firstInt: Int = names.first()

    val things = mutableListOf<Any>(1, 2)
    things.add("Steve")
    println("Things: ${things.toBulletedList()}")

    /**
     * Maps
     */
    val map = mapOf(Pair("one", 1),Pair("two", "II"), Pair("three", 3.0f))
    // val one = map[1]
    val valuesForKeysWithE = map.keys
        .filter { it.contains("e") }
        .map { "Value for $it: ${map[it]}" }
    println("Values for keys with E: ${valuesForKeysWithE.toBulletedList()}")
}
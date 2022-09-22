package t_generics

fun <T> List<T>.toBulletedList(): String {
    val separator = "\n - "
    return this.joinToString(prefix = separator, separator = separator, postfix = "\n") { "$it" }
}

interface Checkable {
    fun checkIsOk(): Boolean
}

class Mover<T: Checkable>(thingsToMove: List<T>, val truckHeightInInches: Int = (12 * 12)) {
    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingsInTrack = mutableListOf<T>()
    private var thingsInNewPlace = mutableListOf<T>()
    private var thingsWhichFailedCheck = mutableListOf<T>()

    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    fun moveEverythingToTruck() {
        while (thingsLeftInOldPlace.isNotEmpty()) {
            val item = thingsLeftInOldPlace.removeAt(0)
            if (item.checkIsOk()) {
                thingsInTrack.add(item)
                println("Moved your $item to the truck")
            } else {
                thingsWhichFailedCheck.add(item)
                println("Could not move your $item to the truck")
            }
        }
    }

    fun moveEverythingIntoNewPlace() {
        while (thingsInTrack.isNotEmpty()) {
            val item = thingsInTrack.removeAt(0)
            if (item.checkIsOk()) {
                thingsInNewPlace.add(item)
                println("Moved your $item into your new place")
            } else {
                thingsWhichFailedCheck.add(item)
                println("Could not move your $item into your new place :/")
            }
        }
    }

    fun finishMove() {
        println("OK, we finished! We moved to the new place the items:${thingsInNewPlace.toBulletedList()}")
        if (thingsWhichFailedCheck.isNotEmpty()) {
            println("But we need to talk about your:${thingsWhichFailedCheck.toBulletedList()}")
        }
    }
}

class CheapThing(val name: String): Checkable {

    override fun checkIsOk(): Boolean {
        return true
    }

    override fun toString(): String {
        return name
    }
}

class BreakableThing(val name: String, var isBroken: Boolean = false): Checkable {

    fun smash() {
        isBroken = true
    }

    override fun checkIsOk(): Boolean {
        return !isBroken
    }

    override fun toString(): String {
        return name
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

    val cheapThings = listOf(
        CheapThing("Cinder block table"),
        CheapThing("Box of old books"),
        CheapThing("Ugly old couch"),
    )
    val cheapMover = Mover(cheapThings)
    cheapMover.moveEverythingToTruck()
    cheapMover.moveEverythingIntoNewPlace()
    cheapMover.finishMove()

    println("-----------")

    val television = BreakableThing("Flat screen television")
    val breakableThings = listOf(
        television,
        BreakableThing("Mirror"),
        BreakableThing("Guitar")
    )

    val expensiveMover = Mover(breakableThings)
    expensiveMover.moveEverythingToTruck()
    television.smash()
    expensiveMover.moveEverythingIntoNewPlace()
    expensiveMover.finishMove()
}
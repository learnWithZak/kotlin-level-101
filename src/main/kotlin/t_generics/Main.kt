package t_generics

import java.lang.RuntimeException

fun <T> List<T>.toBulletedList(): String {
    val separator = "\n - "
    return this.joinToString(prefix = separator, separator = separator, postfix = "\n") { "$it" }
}

interface Checkable {
    fun checkIsOk(): Boolean
}

class Mover<T: Checkable>(
    thingsToMove: List<T>,
    val truckHeightInInches: Int = (12 * 12)
) {

    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingsInTruck = mutableListOf<Any>()
    private var thingsInNewPlace = mutableListOf<T>()

    private var thingsWhichFailedCheck = mutableListOf<T>()

    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    fun moveEverythingToTruck(startingContainer: Container<T>?) {
        var currentContainer = startingContainer
        while (thingsLeftInOldPlace.isNotEmpty()) {
            val item = thingsLeftInOldPlace.removeAt(0)

            if (item.checkIsOk()) {
                if (currentContainer != null) {
                    if (!currentContainer.canAddAnotherItem()) {
                        moveContainerToTruck(currentContainer)
                        currentContainer = currentContainer.getAnother()
                    }

                    currentContainer.addItem(item)
                    println("Packed your $item!")
                } else {
                    thingsInTruck.add(item)
                    println("Moved your $item to the truck!")
                }
            } else {
                thingsWhichFailedCheck.add(item)
                println("Could not move your $item to the truck :[")
            }
        }

        currentContainer?.let { moveContainerToTruck(it)}
    }

    private fun moveContainerToTruck(container: Container<T>) {
        thingsInTruck.add(container)
        println("Moved a container with your ${container.contents().toBulletedList()} to the truck!")
    }

    fun moveEverythingIntoNewPlace() {
//    val breakableThings = thingsInTruck.filterIsInstance<BreakableThing>()
//    break
//    val items = thingsInTruck.filterIsInstance<T>()

        val containers = thingsInTruck.filterIsInstance<Container<T>>()
        for (container in containers) {
            thingsInTruck.remove(container)
            while (container.canRemoveAnotherItem()) {
                val itemInContainer = container.removeItem()
                println("Unpacked your $itemInContainer!")
                tryToMoveItemIntoNewPlace(itemInContainer)
            }
        }

        while (thingsInTruck.isNotEmpty()) {
            @Suppress("UNCHECKED_CAST")
            val item = thingsInTruck.removeAt(0) as? T

            if (item != null) {
                tryToMoveItemIntoNewPlace(item)
            } else {
                println("Something in the truck was not of the expected generic type: $item")
            }
        }
    }

    private fun tryToMoveItemIntoNewPlace(item: T) {
        if (item.checkIsOk()) {
            thingsInNewPlace.add(item)
            println("Moved your $item into your new place!")
        } else {
            thingsWhichFailedCheck.add(item)
            println("Could not move your $item into your new place :[")
        }
    }

    fun finishMove() {
        println("OK, we finished! We were able to move your:${thingsInNewPlace.toBulletedList()}")
        if (thingsWhichFailedCheck.isNotEmpty()) {
            println("But we need to talk about your:${thingsWhichFailedCheck.toBulletedList()}")
        }
    }

    fun fitsInTruck(itemHeight: Int): Boolean {
        return truckHeightInInches > itemHeight
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

interface Container<T> {
    fun canAddAnotherItem(): Boolean
    fun addItem(item: T)

    fun canRemoveAnotherItem(): Boolean
    fun removeItem(): T

    fun getAnother(): Container<T>
    fun contents(): List<T>
}

class CardboardBox: Container<BreakableThing> {

    private var items = mutableListOf<BreakableThing>()

    override fun canAddAnotherItem(): Boolean {
        return items.count() < 2
    }

    override fun canRemoveAnotherItem(): Boolean {
        return items.isNotEmpty()
    }

    override fun removeItem(): BreakableThing {
        val lastItem = items.last()
        items.remove(lastItem)
        return lastItem
    }

    override fun getAnother(): Container<BreakableThing> {
        return CardboardBox()
    }

    override fun contents(): List<BreakableThing> {
        return items.toList()
    }

    override fun addItem(item: BreakableThing) {
        items.add(item)
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
    cheapMover.moveEverythingToTruck(null)
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
    expensiveMover.moveEverythingToTruck(CardboardBox())
    television.smash()
    expensiveMover.moveEverythingIntoNewPlace()
    expensiveMover.finishMove()

    val ints = listOf(1, 2, 3)
    val numbers: List<Number> = ints
    // val moreInts: List<Int> = numbers

    val mutableInts = mutableListOf(1,2,3)
    // val mutableNumbers: MutableList<Number> = mutableInts

    fun compare(comparator: Comparable<Number>) {
        val int: Int = 1
        comparator.compareTo(int)
        val float: Float = 1.0F
        comparator.compareTo(float)
        val intComparable: Comparable<Int> = comparator
        intComparable.compareTo(int)
        // intComparable.compareTo(float)
    }

    /**
     * Challenges
     */

    val classmates = listOf(
        Classmate("Ralph", "Toto"),
        Classmate("Jonny", "Hallyday"),
        Classmate("Sherri", "Mackleberry"),
        Classmate("Terri", "Manes")
    )

    println("Classmates:")
    classmates.printNames()

    val family = listOf(
        Relative("Homer", "Simpson", "Father"),
        Relative("Marge", "Simpson", "Mother"),
        Relative("Bart", "Simpson", "Brother"),
        Relative("Maggie", "Simpson", "Sister")
    )
    println("Family:")
    family.printNames()

    val vehicles = listOf(
        Vehicle("Yamaha", "Vino", 40),
        Vehicle("Toyota", "Corolla", 58),
        Vehicle("Freightliner", "Cascadia", 150)
    )

    val vehicleMover = Mover(vehicles)
    vehicles.forEach {
        it.heightCheckLambda = vehicleMover::fitsInTruck
    }
    vehicleMover.moveEverythingToTruck(ShippingContainer())
    vehicleMover.moveEverythingIntoNewPlace()
    vehicleMover.finishMove()

    println("-------move all--------")
    var items = mutableListOf<Checkable>()
    items.addAll(cheapThings)
    items.addAll(breakableThings)
    items.addAll(vehicles)
    val everythingMover = Mover(items, 200)
    vehicles.forEach { it.heightCheckLambda = everythingMover::fitsInTruck }

    everythingMover.moveEverythingToTruck(null)
    everythingMover.moveEverythingIntoNewPlace()
    everythingMover.finishMove()
}

/**
 * Challenges
 */

interface PersonWithName {
    val firstName: String
    val lastName: String
}

class Classmate(override val firstName: String, override val lastName: String): PersonWithName

class Relative(override val firstName: String, override val lastName: String, val relationship: String): PersonWithName {

    override fun toString(): String {
        return "$relationship: $firstName $lastName"
    }
}

fun <T: PersonWithName> List<T>.printNames() {
    forEach {
        println("${it.firstName} ${it.lastName}")
    }
}

class Vehicle(val brandName: String, val modelName: String, val heightInInches: Int): Checkable {
    var heightCheckLambda: ((Int) -> Boolean)? = null

    override fun checkIsOk(): Boolean {
        heightCheckLambda?.let {
            return it.invoke(heightInInches)
        }
        throw RuntimeException("You must provide a height check function!")
    }

    override fun toString(): String {
        return "$brandName $modelName"
    }
}

class ShippingContainer: Container<Vehicle> {

    var currentVehicle: Vehicle? = null

    override fun canAddAnotherItem(): Boolean {
        return currentVehicle == null
    }

    override fun canRemoveAnotherItem(): Boolean {
        return currentVehicle != null
    }

    override fun removeItem(): Vehicle {
        //todo: that cast mmm!!!
        val itemToReturn = currentVehicle as Vehicle
        currentVehicle = null
        return itemToReturn
    }

    override fun getAnother(): Container<Vehicle> {
        return ShippingContainer()
    }

    override fun contents(): List<Vehicle> {
        val list = mutableListOf<Vehicle>()
        currentVehicle?.let {
            list.add(it)
        }
        return list
    }

    override fun addItem(item: Vehicle) {
        this.currentVehicle = item
    }
}
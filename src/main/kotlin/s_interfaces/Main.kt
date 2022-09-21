package s_interfaces

import kotlin.math.PI

interface Vehicle {
    fun accelerate()
    fun stop()
}

class Unicycle: Vehicle {
    var paddling = false

    override fun accelerate() {
        paddling = true
    }

    override fun stop() {
        paddling = false
    }

}

enum class Direction {
    LEFT, RIGHT
}

interface DirectionalVehicle {
    fun accelerate()
    fun stop()
    fun turn(direction: Direction)
    fun description(): String
}

interface OptionalDirectionalVehicle {
    fun turn(direction: Direction = Direction.LEFT)
}

class OptionalDirection: OptionalDirectionalVehicle {
    override fun turn(direction: Direction) {
        println(direction)
    }
}

interface SpaceVehicle {
    fun accelerate()
    fun stop() {
        println("Whoa, slow down")
    }
}

class LightFreighter: SpaceVehicle {
    override fun accelerate() {
        println("Proceed to hyperspace!")
    }
}

class Starship: SpaceVehicle {
    override fun accelerate() {
        println("Warp factor 9 please")
    }

    override fun stop() {
        super.stop()
        println("That kind of hurt!")
    }
}

interface VehicleProperties {
    val weight: Int
    val name: String
        get() = "Vehicle"

}

class Car: VehicleProperties {
    override val weight: Int = 1000
}

class Tank: VehicleProperties {
    override val weight: Int
        get() = 1000

    override val name: String
        get() = "Tank"

}

interface WheeledVehicle: Vehicle {
    val numberOfWheels: Int
    var wheelSize: Double
}

/**
 * implementing multiple interfaces
 */
interface Wheeled {
    val numberOfWheels: Int
    var wheelSize: Double
}

class Tricycle: Wheeled, Vehicle {
    var peddling = false
    var brakesApplied = false

    override val numberOfWheels: Int = 3
    override var wheelSize: Double = 100.0

    override fun accelerate() {
        peddling = true
        brakesApplied = false
    }

    override fun stop() {
        peddling = false
        brakesApplied = true
    }
}

class Bike: WheeledVehicle {
    var paddling = false
    var brakesApplied = false

    override val numberOfWheels: Int = 2
    override var wheelSize: Double = 622.0

    override fun accelerate() {
        paddling = true
        brakesApplied = false
    }

    override fun stop() {
        paddling = false
        brakesApplied = true
    }

}

fun main() {
    val car = OptionalDirection()
    car.turn()
    car.turn(Direction.RIGHT)

    val freighter = LightFreighter()
    freighter.accelerate()
    freighter.stop()

    val starship = Starship()
    starship.accelerate()
    starship.stop()

    /**
     * Mini-exercises
     */
    val circle = Circle(2.0)
    val square = Square(4.0)
    val triangle = Triangle(3.0, 5.0)

    val shapes = arrayOf(circle, square, triangle)
    println(shapes.map {
        it.area
    })

    /**
     * Interface in the standard libraries
     */
    val cars = listOf("Ferrari", "Lambourghini", "Rolls-Royce")
    val numbers = mapOf("Brady" to 12, "Manning" to 18, "Brees" to 9)

    for (oneCar in cars) {
        println(oneCar)
    }

    for (qb in numbers) {
        println("${qb.key} wears ${qb.value}")
    }

    val titanic = Boat()
    titanic.length = 883

    val qe2 = Boat()
    qe2.length = 963

    println(titanic < qe2)
}

/**
 * Mini-exercises
 */

interface Area {
    val area: Double
}

class Square(private val side: Double): Area {
    override val area: Double
        get() = side * side
}

class Triangle(private val base: Double, private val height: Double): Area {
    override val area: Double
        get() = 0.5 * base * height
}

class Circle(private val radius: Double): Area {
    override val area: Double
        get() = PI * radius * radius
}

/**
 * Comparable
 */
interface SizedVehicle {
    var length: Int
}

class Boat: SizedVehicle, Comparable<Boat> {

    override var length: Int = 0

    override fun compareTo(other: Boat): Int {
        return when {
            length > other.length -> 1
            length == other.length -> 0
            else -> -1
        }
    }
}
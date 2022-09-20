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

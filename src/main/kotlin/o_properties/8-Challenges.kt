package o_properties

import kotlin.properties.Delegates

fun main() {
    val myCar = NewCar("BMW", "Black", FuelTank())
    myCar.fuelTank.level = 1.0
    println(myCar.fuelTank.lowFuel)
    println("is low fuel? ${myCar.fuelTank.lowFuel}")
    println("----------Driving!---------")
    myCar.fuelTank.level = 0.05
    println("is low fuel? ${myCar.fuelTank.lowFuel}")
}

class IceCream {
    val name: String = ""
    val ingredients: ArrayList<String> by lazy {
        arrayListOf()
    }
}

class FuelTank {
    var lowFuel = true

    var level: Double by Delegates.observable(0.0) { _, _, new ->
        lowFuel = new < 0.1
    }

}

class NewCar(val make: String, val color: String, val fuelTank: FuelTank)
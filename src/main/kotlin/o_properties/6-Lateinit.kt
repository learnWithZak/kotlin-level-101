package o_properties

fun main() {
    val lamp = Lamp()
    // println(lamp.bulb) //Error
    lamp.bulb = LightBulb()
    println(lamp.bulb.current)
}

class Lamp {
    lateinit var bulb: LightBulb
}
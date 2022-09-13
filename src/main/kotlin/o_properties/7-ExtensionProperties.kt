package o_properties

val Circle.diameter: Double
    get() = 2.0 * radius

fun main() {
    val unitCircle = Circle(1.0)
    println(unitCircle.diameter)
}
package u_exceptions

import java.lang.Exception

fun main() {
    // someFunction()
    val spaceCraft = SpaceCraft()
    SpacePort.investigateSpace(spaceCraft)

    println(SpacePort.testSetup(spaceCraft))
}

fun someFunction() {
    anotherFunction()
}

fun anotherFunction() {
    oneMoreFunction()
}

fun oneMoreFunction() {
    throw Exception("Something went wrong")
}

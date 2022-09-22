package u_exceptions

import java.lang.Exception

fun main() {
    someFunction()
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

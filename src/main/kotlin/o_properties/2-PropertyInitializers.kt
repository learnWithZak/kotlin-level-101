package o_properties

class Person(val firstName: String, val lastName: String) {
    val fullName = "$firstName $lastName"
}

fun main() {
    val person = Person("Grace", "Hopper")
    println(person.fullName)

    val address = Address()
}

class Address {
    var address1: String
    var address2: String? = null
    var city = ""
    var state: String

    init {
        address1 = ""
        state = ""
    }
}

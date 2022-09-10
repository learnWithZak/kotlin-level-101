package m_classes

fun main() {
    class Person(var firstName: String, var lastName: String) {
        val fullName = "$firstName $lastName"
    }
    val togo = Person(firstName = "togo", lastName = "morry")
    println(togo.fullName)
}
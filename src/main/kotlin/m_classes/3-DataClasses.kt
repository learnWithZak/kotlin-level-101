package m_classes

fun main() {
    data class StudentData(
        var firstName: String,
        var lastName: String,
        var id: Int
    )

    val marie = StudentData("Marie", "Curie", 1)
    val emmy = StudentData("Emmy", "Noether", 2)
    val marieCopy = marie.copy()

    println(marie)
    println(emmy)
    println(marie == emmy)
    println(marie == marieCopy)
    println(marie === marieCopy)

    /**
     * Destructuring declarations
     */
    val (firstName, lastName, id) = marie
    println(firstName)
    println(lastName)
    println(id)
}

package t_generics

fun main() {
    val names = listOf("Bob", "Carol", "Ted", "Alice")
    println("Names: $names")
    val firstName = names.first()
    println(firstName)
    // val firstInt: Int = names.first()

    val things = mutableListOf<Any>(1, 2)
    things.add("Steve")
    println("Things: $things")

}
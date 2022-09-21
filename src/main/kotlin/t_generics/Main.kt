package t_generics

fun main() {
    val names: List<String> = listOf("Bob", "Carol", "Ted", "Alice")
    println("Names: $names")
    val firstName = names.first()
    println(firstName)
}
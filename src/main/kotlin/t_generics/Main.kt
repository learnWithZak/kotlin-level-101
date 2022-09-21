package t_generics

fun <T> List<T>.toBulletedList(): String {
    val separator = "\n - "
    return this.joinToString(prefix = separator, separator = separator, postfix = "\n") { "$it" }
}

fun main() {
    val names = listOf("Bob", "Carol", "Ted", "Alice")
    println("Names: ${names.toBulletedList()}")
    val firstName = names.first()
    println(firstName)
    // val firstInt: Int = names.first()

    val things = mutableListOf<Any>(1, 2)
    things.add("Steve")
    println("Things: ${things.toBulletedList()}")

    /**
     * Maps
     */
    val map = mapOf(Pair("one", 1),Pair("two", "II"), Pair("three", 3.0f))
    // val one = map[1]
    val valuesForKeysWithE = map.keys
        .filter { it.contains("e") }
        .map { "Value for $it: ${map[it]}" }
    println("Values for keys with E: ${valuesForKeysWithE.toBulletedList()}")
}
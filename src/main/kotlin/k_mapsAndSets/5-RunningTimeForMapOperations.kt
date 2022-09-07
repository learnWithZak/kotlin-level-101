package k_mapsAndSets

fun main() {
    // hashing is the process of transforming a value to a numeric value (hash value).
    // this value (hash value) can be used to search quickly the values in a hash table.

    println("some string".hashCode())
    println(1.hashCode())
    println(false.hashCode())

    // hashCode will always return the same value

    // for performance-critical code, use HashMap<K, V> via hashMapOf() instead of mapOf()
}
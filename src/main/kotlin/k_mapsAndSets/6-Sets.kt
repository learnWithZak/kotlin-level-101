package k_mapsAndSets

// set is an unordered collection of unique values of the same type
// it's useful if you want to ensure that an item doesn't appear more than once in the collection

fun main() {
    /**
     * Creating sets
     */
    val names = setOf("Anna", "Brian", "Craig", "Anna")
    println(names)
    val hashSet = HashSet<Int>()

    /**
     * set from arrays
     */
    val someArray = arrayOf(1, 2, 3, 1)
    // spread operator: when we call a varargs function, we can pass arguments one by one, or if we already have an array, and want to pass its contents to the function, we use spread operator
    val someSet = mutableSetOf(*someArray)
    println(someSet) // 1,2,3

}
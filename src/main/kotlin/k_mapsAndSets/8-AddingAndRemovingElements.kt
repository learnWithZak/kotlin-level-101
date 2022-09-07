package k_mapsAndSets

fun main() {
    val someArray = arrayOf(1, 2, 3, 1)
    val someSet = mutableSetOf(*someArray)
    someSet.add(5)

    val removedOne = someSet.remove(1)
    println(removedOne)

    println(someSet)

    /**
     * Running time for set operations
     */

    //use HashSet
}
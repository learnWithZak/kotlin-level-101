package k_mapsAndSets

fun main() {

    val someArray = arrayOf(1, 2, 3, 1)
    val someSet = mutableSetOf(*someArray)

    println(someSet.contains(1))
    println(2 in someArray)

    for (number in someSet) {
        println(number)
    }
}
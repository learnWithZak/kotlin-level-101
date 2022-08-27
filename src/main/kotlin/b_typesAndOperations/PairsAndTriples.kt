package b_typesAndOperations

fun main() {
    val coordinates: Pair<Int, Int> = Pair(2, 3)
    val coordinatesInferred = Pair(2, 3)
    val coordinatesWithTo = 2 to 3
    val coordinatesDoubles = Pair(1.3, 3.5)
    val coordinatesMixed = Pair(2.1, 4) // Pair<Double, Int>

    val x1 = coordinates.first
    val y1 = coordinates.second
    //Or using destructuring declaration
    val (x,y) = coordinates

    val coordinates3D = Triple(2,3,1)
    val (x3, y3, z3) = coordinates3D
    val (x4, y4, _) = coordinates3D

    /**
     * Mini-exercises
     */
    val datesAsTriple = Triple(8, 1, 1996)
    val (day, month, year) = datesAsTriple
    var (_, month2, year2) = datesAsTriple
    month2 = 2
    val updatedDate = month2 to year2
}
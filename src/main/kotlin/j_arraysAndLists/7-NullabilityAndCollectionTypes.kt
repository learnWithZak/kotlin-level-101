package j_arraysAndLists

fun main() {
    var nullableList: List<Int>? = listOf(1, 2, 3, 4)
    nullableList = null

    var listOfNullables: List<Int?> = listOf(1, 2, null, 4)
    // listOfNullables = null // Null can not be a value of a non-null type List<Int?>

    var nullableListOfNullables: List<Int?>? = listOf(1, 2, null, 4)
    nullableListOfNullables = null
}
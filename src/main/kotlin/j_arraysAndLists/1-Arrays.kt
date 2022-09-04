package j_arraysAndLists

/**
 * What is an array?
 */
// ordered collection of values
// fixed size
// zero indexed

/**
 * When are array useful?
 */
// if you want to store elements in a particular order
// if you want to fetch elements by index without iterating through the entire array

/**
 * Creating arrays
 */
val evenNumbers = arrayOf(2, 4, 6, 8) // 2,4,6,8
val fiveFives = Array(5) { 5 } // 5,5,5,5,5

val vowels = arrayOf("a", "e", "o", "u", "i")

/**
 * Arrays as primitive types
 */
val myArray: Array<Int> = arrayOf(1, 2, 3, 4) // list of object types. The integer type is the boxed `Integer` and not the primitive type `int`

// using primitive type over boxed will consume less memory -> better performance
// So we need to create arrays that correspond to arrays of primitive types

val oddNumbers = intArrayOf(1, 3, 5, 7) // floatArrayOf, doubleArrayOf, booleanArrayOf
val zeros = DoubleArray(4) //0.0, 0.0, 0.0, 0.0

// to convert between the boxed and primitive arrays
val otherOddNumbers = arrayOf(1, 3, 5, 7).toIntArray()

/**
 * Arguments to main()
 */

// adding arguments using Edit configurations...
fun main(args: Array<String>) {
    /**
     * Iterating over an array
     */
    for (arg in args) {
        println(arg)
    }
    println("--------")
    args.forEach { arg ->
        println(arg)
    }
}
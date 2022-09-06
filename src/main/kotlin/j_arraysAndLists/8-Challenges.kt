package j_arraysAndLists

import java.util.*

fun main() {
    // val array1 = Array<Int>()
    // val array2 = arrayOf()
    val array3: Array<String> = arrayOf()
    val array4 = arrayOf(1,2,3)
    println(array4[0])
    // println(array4[5]) // IndexOutOfBoundsException
    array4[0] = 4

    val array5 = arrayOf(1, 2, 3)
    array5[0] = array5[1]
    // array5[0] = "Six"
    // array5 += 6 // you should use var
    for (item in array5) {
        println(item)
    }

    fun removeOne(item: Int, list: List<Int>): List<Int> {
        val mutableList = list.toMutableList()
        if (!mutableList.remove(item)) {
            println("Item not found")
        }
        return mutableList
    }

    println(removeOne(1, mutableListOf(1,2,3,4)))
    println(removeOne(55, mutableListOf(1,2,3,4)))

    fun remove(item: Int, list: List<Int>): List<Int> {
        val mutableList = list.toMutableList()
        for (element in list) {
            if (element == item) mutableList.remove(item)
        }
        return mutableList
    }

    println(remove(1, listOf(1,2,3,4,1,1,1,1,4,9)))

    fun reverse(array: Array<Int>): Array<Int> {
        var reversedArray = arrayOf<Int>()
        println(array.size)
        for (reversedNumber in array.last() downTo array.first()) {
            reversedArray += reversedNumber
        }
        return reversedArray
    }

    println(reverse(arrayOf(1,2,3,4,5)).joinToString())

    fun rand(from: Int, to: Int) : Int {
        return Random().nextInt(to - from) + from
    }
    println(rand(0, 5))

    fun randomized(array: Array<Int>): Array<Int> {
        val shuffledArray = Array(array.size) {0}
        val chosenPositions = mutableListOf<Int>()
        var random: Int
        for ( index in array.indices) {
            while (true) {
                random = rand(0, array.size)
                if (random !in chosenPositions) {
                    chosenPositions.add(random)
                    break
                }
            }
            shuffledArray[index] = array[random]
        }
        return shuffledArray
    }

    println(randomized(arrayOf(1,5,6,7)).joinToString())

    fun minMax(numbers: Array<Int>): Pair<Int, Int>? {
        var min = 0
        var max = 0
        return if (numbers.isEmpty())
            null
        else {
            for (number in numbers) {
                if (number > max) {
                    max = number
                }
                if (number < min) {
                    min = number
                }
            }
            Pair(min, max)
        }
    }

    println(minMax(arrayOf(4, -54, -300, 23, 55666, 22, 1, -2223, 33, 11, 500000)))
}
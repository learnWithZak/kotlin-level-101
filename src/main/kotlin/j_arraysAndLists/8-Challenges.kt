package j_arraysAndLists

import java.util.*
import javax.lang.model.type.ArrayType

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
}
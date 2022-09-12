package o_properties

import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * Custom getter
 */
class TV(var height: Double, var width: Double) {
    var diagonal: Int
        get() {
            val result = sqrt(height * height + width * width)
            return result.roundToInt()
        }
        set(value) {
            val ratioWidth = 16.0
            val rationHeight = 9.0

            val ratioDiagonal = sqrt(ratioWidth * ratioWidth + rationHeight * rationHeight)
            height = value.toDouble() * rationHeight / ratioDiagonal
            width = height * ratioWidth / rationHeight
        }
}

fun main() {
    val tv = TV(height = 53.93, width = 95.87)
    val size = tv.diagonal
    println("$size\"")

    tv.width = tv.height
    val diagonal = tv.diagonal
    println("$diagonal\"")

    /**
     * Custom setter
     */

    tv.diagonal = 70
    println(tv.width)
    println(tv.height)
}
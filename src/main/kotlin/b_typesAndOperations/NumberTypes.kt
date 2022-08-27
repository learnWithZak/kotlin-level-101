package b_typesAndOperations

fun main() {
    /**
     * For whole numbers, you can use Byte, Short, Int, Long.
     *      Byte: 8bits.
     *      Short: 2Bytes = 16bits.
     *      Int: 4Bytes = 32bits.
     *      Long: 8Bytes = 64bits.
     *
     * For fractional numbers, you can use Double or Float.
     * Float is less precise than Double, and requires half the storage of Double.
     */

    val a: Short = 12
    val b: Byte = 120
    val c: Int = 10000
    val answer = a + b + c // int
    val d: Long = 200
    val answer2 = a + b + c + d // long
}
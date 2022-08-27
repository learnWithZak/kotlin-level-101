package b_typesAndOperations

fun main() {
    // Any is like Object in Java
    val anyNumber: Any = 42
    val anyString: Any = "42"

    //Unit is similar to void in Java. It's a return type
    fun add(): Unit {
        val addition = 2 + 2
        println(addition)
    }

    // "Nothing" does nothing and never completes
    fun doNothingForever(): Nothing {
        while (true) {

        }
    }
}
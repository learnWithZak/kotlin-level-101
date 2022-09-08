package l_lambdas

import java.lang.NullPointerException

fun main() {
    // lambda expression = a function with no name (anonymous functions)
    // they are known as closures

    /**
     * Lambda basics
     */
    var multiplyLambda: (Int, Int) -> Int
    multiplyLambda = { a: Int, b: Int -> Int
        a * b
    }
    val lambdaResult = multiplyLambda(4, 2)
    println(lambdaResult)

    /**
     * Shorthand syntax
     */
    multiplyLambda = {a, b ->
        a * b
    }

    /**
     * it keyword
     */
    var doubleLambda = {a: Int ->
        2 * a
    }
    doubleLambda = { 2 * it }

    val square: (Int) -> Int = { it * it }

    /**
     * Lambdas as arguments
     */
    fun operateOnNumbers(
        a: Int,
        b: Int,
        operation: (Int, Int) -> Int
    ): Int {
        val result = operation(a, b)
        println(result)
        return result
    }

    operateOnNumbers(4,2, operation = {a: Int, b:Int -> a + b})

    fun addFunction(a:Int, b:Int) = a + b
    operateOnNumbers(4,2, ::addFunction)

    operateOnNumbers(4,2, operation = {a: Int, b: Int -> a + b})
    operateOnNumbers(4,2, operation = {a, b -> a + b})
    operateOnNumbers(4,2, operation = Int::plus)
    operateOnNumbers(4,2) { a, b ->
        a + b
    }

    /**
     * Lambdas with no meaningful return value
     */
    val unitLambda: () -> Unit = {
        println("learn kotlin is awesome!")
    }
    unitLambda()

    val nothingLambda: () -> Nothing = {
        throw NullPointerException()
    }
    // nothingLambda()

    /**
     * Capturing from the enclosing scope
     */
    var counter = 0
    val incrementCounter = {
        counter += 1 // the lambda is able to access to the variable because the lambda is defined in the same scope as the variable
    }
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    println(counter)

    println("---------------")
    fun countingLambda(): () -> Int {
        var newCounter = 0
        println("newCounter value is $newCounter")
        val newIncrementCounter: () -> Int = {
            newCounter += 1
            println("newCounter value in lambda is $newCounter")
            newCounter
        }
        return newIncrementCounter
    }

    val counter1 = countingLambda()
    val counter2 = countingLambda()
    println("counter1")
    println(counter1()) //1
    println("counter2")
    println(counter2()) //1
    println("counter1")
    println(counter1())
    println(counter1())
    println("counter2")
    println(counter2())

}
package l_lambdas

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
}
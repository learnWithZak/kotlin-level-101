package basicControlFlow

fun main() {
    val yes: Boolean = true
    val no: Boolean = false

    val yesInferred = true
    val noInferred = false

    /**
     * Boolean operators
     */

    val doesOneEqualsTwo = (1 == 2)
    println(doesOneEqualsTwo)

    val doesOneNotEqualTwo = (1 != 2)
    println(doesOneNotEqualTwo)

    val alsoTrue = !(1 == 2)
    println(alsoTrue)

    val isOneGreaterThanTwo = (1 > 2)
    val isOneLessThanTwo = (1 < 2)

    println(isOneGreaterThanTwo)
    println(isOneLessThanTwo)

    /**
     * Boolean logic
     */

    val and = true && true
    val or = true || false

    val andTrue = 1 < 2 && 4 > 3
    println(andTrue)
    val andFalse = 1 < 2 && 3 > 4
    println(andFalse)

    val orTrue = 1 < 2 || 3 > 4
    println(orTrue)
    val orFalse = 1 == 2 || 3 == 4
    println(orFalse)

    val andOr = (1 < 2 && 3 > 4) || 1 < 4
    println(andOr)

    /**
     * String equality
     */

    val guess = "dog"
    val dogEqualsCat = guess == "cat"

    val order = "cat" < "dog" //checks if a string comes before another string alphabetically
    println(order)

    /**
     * Mini exercise
     */
    println("-------------------")
    val myAge = 26
    val isTeenager = myAge >= 13 && myAge <= 19
    println(isTeenager)

    val theirAge = 30
    val bothTeenagers = (theirAge >= 13 && theirAge <= 19) && isTeenager

    println(bothTeenagers)

    val reader = "Zakaria"
    val author = "Richard"
    val authorIsReader = reader == author
    println(authorIsReader)
    val readerBeforeAuthor = reader < author
    println(readerBeforeAuthor)
    println("-------------------")


}
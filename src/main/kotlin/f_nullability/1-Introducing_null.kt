package f_nullability

fun main() {
    var name = "Zak"
    var age = 24
    var occupation = "Freelance Software developer & happy $ :)"

    /**
     * Sentinel values (guard)
     */
    var errorCode = 0 // lack of error is 0 -> 0 is a sentinel value

    /**
     * Introducing nullable types
     */
    var newErrorCode: Int?
    newErrorCode = 100
    newErrorCode = null

    /**
     * Mini-exercises
     */
    var myFavoriteSong: String?
    //myFavoriteSong = null // I have no favorite song now!
    myFavoriteSong = "Manzak a winou - Oudaden"
    var parseInt = "10".toIntOrNull()
    println(parseInt)
    parseInt = "dog".toIntOrNull()
    println(parseInt)

    /**
     * Checking for null
     */
    val result: Int? = 30
    println(result)
    // println(result + 1) // not allowed because result is nullable

    /**
     * Not-null assertion operator --> could produce runtime error
     */
    var authorName: String? = "Sefrioui"
    var authorAge: Int? = 65
    var ageAfterBirthday = authorAge!! + 1 // look inside the box and take out the value
    println("After their next birthday, the author will be $ageAfterBirthday")

    /**
     * Smart cast
     */
    var nonNullableAuthor: String
    var nullableAuthor: String?
    if (authorName != null) {
        nonNullableAuthor = authorName
    } else {
        nullableAuthor = authorName
    }

    /**
     * Mini-exercises
     */

    if (myFavoriteSong != null) {
        println("The value of my favorite song is $myFavoriteSong")
    } else {
        println("I don't have a favorite song")
    }

    /**
     * Safe calls
     */
    var nameLength = authorName?.length
    println("Author's name has length $nameLength.")
    val nameLengthPlus5 = authorName?.length?.plus(5)
    println("Author's name length plus 5 is $nameLengthPlus5")
    // authorName = null
    val nameLengthChainCall = authorName?.length?.plus(5)?.plus(3)?.minus(4)
    println(nameLengthChainCall)

    /**
     * The let() function
     */
    authorName?.let {
        nonNullableAuthor = authorName
        nameLength = authorName.length
    }

    /**
     * Elvis operator
     */
    var nullableInt: Int? = 10
    // var mustHaveResult = if (nullableInt == null) 0 else nullableInt
    var mustHaveResult = nullableInt ?: 0
    println(mustHaveResult)
    nullableInt = null
    mustHaveResult = nullableInt ?: 0
    println(mustHaveResult)

    /**
     * Challenges
     */

    // divide and conquer
    fun divideIfWhole(number: Int, divisor: Int): Int? {
        return if (number % divisor == 0) {
            number / divisor
        }
        else {
            null
        }
    }

    var divisionResult = divideIfWhole(10, 2)
    // printResult(divisionResult)
    printRefactoredResult(divisionResult)
    divisionResult = divideIfWhole(10, 3)
    // printResult(divisionResult)
    printRefactoredResult(divisionResult)

    // Refactor
}

private fun printResult(divisionResult: Int?) {
    if (divisionResult != null) println("Yep, it divides $divisionResult times") else println("No divisible :(")
}

private fun printRefactoredResult(divisionResult: Int?) {
    val howManyTime = divisionResult ?: 0
    println("It divides $howManyTime times.")
}
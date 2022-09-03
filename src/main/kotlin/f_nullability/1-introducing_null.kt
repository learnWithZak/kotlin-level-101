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
    myFavoriteSong = null // I have no favorite song now!

    var parseInt = "10".toIntOrNull()
    println(parseInt)
    parseInt = "dog".toIntOrNull()
    println(parseInt)
}
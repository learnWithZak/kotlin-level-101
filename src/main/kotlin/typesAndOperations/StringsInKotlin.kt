fun main() {
    /**
     * Characters and names
     */
    val characterA: Char = 'a'
    val stringDog: String = "Dog" // <- the right hand is called : string literal
    val stringDogInferred = "Dog"

    /**
     * Concatenation
     */
    var message = "Hello" + " my name is "
    val name = "Joe"
    message += name
    println(message)
    val exclamationMark: Char = '!'
    message += exclamationMark
    println(message)

    /**
     * String templates
     */
    val newName = "John"
    message = "Hello my name is $newName!"
    println(message)

    val oneThird = 1.0 / 3.0
    val oneThirdLongString = "One third is $oneThird as a decimal"
    println(oneThirdLongString)
    val oneThirdLongStringBraces = "One third is ${1.0 / 3.0} as a decimal"
    println(oneThirdLongStringBraces)

    /**
     * Multi-line strings
     */
    val bigString = """
        |You can have a string
        |that contains multiple
        |lines by
        |doing this.
    """.trimMargin() // Supprimer les margins
    println(bigString)

    /**
     * Mini-exercises
     */

    val firstName = "Zak"
    val lastName = "Afir"
    val fullName = "$firstName $lastName"
    val myDetails = "Hello, my name is $fullName."
    println(myDetails)

}
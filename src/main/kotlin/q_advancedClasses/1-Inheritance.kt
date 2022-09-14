package q_advancedClasses

open class Person(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student(
    firstName: String,
    lastName: String,
    var grades: MutableList<Grade> = mutableListOf()
) : Person(firstName, lastName) {

    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

data class Grade(
    val letter: Char,
    val points: Double,
    val credits: Double
)

fun main() {
    val john = Person(firstName = "Johnny", lastName = "Appleseed")
    val jane = Student(firstName = "Johnny", lastName = "Appleseed")

    println(john.fullName())
    println(jane.fullName())

    val history = Grade(letter = 'B', points = 9.0, credits = 3.0)
    jane.recordGrade(history)
    // john.recordGrade(history) // john is not a student!

    /**
     * Polymorphism
     */
    val person = Person(
        firstName = "Johnny",
        lastName = "Appleseed"
    )

    val oboePlayer = OboePlayer(
        firstName = "Jane",
        lastName = "Appleseed"
    )

    println(phoneBookName(person))
    println(phoneBookName(oboePlayer))

    /**
     * Runtime hierarchy checks
     */
}

open class BandMember(
    firstName: String,
    lastName: String
): Student(firstName, lastName) {
    open val minimumPracticeTime: Int
        get() = 2
}

class OboePlayer(
    firstName: String,
    lastName: String
): BandMember(firstName, lastName) {
    override val minimumPracticeTime: Int = super.minimumPracticeTime * 2
}

/**
 * Polymorphism
 */

fun phoneBookName(person: Person): String {
    return "${person.lastName}, ${person.firstName}"
}
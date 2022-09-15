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

    var hallMonitor = Student(firstName = "Jill", lastName = "Bananapeel")
    hallMonitor = oboePlayer
    println(hallMonitor is OboePlayer)
    println(hallMonitor !is OboePlayer)
    println(hallMonitor is Person)

    // (oboePlayer as Student).minimumPracticeTime
    (hallMonitor as? BandMember)?.minimumPracticeTime

    fun afterClassActivity(student: Student): String {
        return "Goes home!"
    }

    fun afterClassActivity(student: BandMember): String {
        return "Goes to practice!"
    }

    println(afterClassActivity(oboePlayer)) // practice
    println(afterClassActivity(oboePlayer as Student)) // home

    val math = Grade(letter = 'B', points = 9.0, credits = 3.0)
    val science = Grade(letter = 'F', points = 9.0, credits = 3.0)
    val physics = Grade(letter = 'F', points = 9.0, credits = 3.0)
    val chemistry = Grade(letter = 'F', points = 9.0, credits = 3.0)

    val dom = StudentAthlete(firstName = "Dom", lastName = "Grady")
    dom.recordGrade(math)
    dom.recordGrade(science)
    dom.recordGrade(physics)
    dom.recordGrade(chemistry)
    println(dom.isEligible)

    /**
     * Abstract classes
     */
    val human = Human(birthdate = "1/1/2020")
    // val mammal = Mammal("1/1/2020") // cannot create an instance of abstract class
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

class StudentAthlete(
    firstName: String,
    lastName: String
): Student(firstName, lastName) {
    val failedClasses = mutableListOf<Grade>()

    override fun recordGrade(grade: Grade) {
        super.recordGrade(grade)

        if (grade.letter == 'F') {
            failedClasses.add(grade)
        }
    }

    val isEligible: Boolean
        get() = failedClasses.size < 3
}

class FinalStudent(firstName: String, lastName: String): Person(firstName, lastName)
// class FinalStudentAthlete(firstName: String, lastName: String): FinalStudent(firstName, lastName) // Compile error
open class AnotherStudent(firstName: String, lastName: String): Person(firstName, lastName) {
    open fun recordGrade(grade: Grade) {}
    fun recordTardy() {}
}

class AnotherStudentAthlete(firstName: String, lastName: String): AnotherStudent(firstName, lastName) {
    override fun recordGrade(grade: Grade) {}
    //override fun recordTardy() {} // error! recordTardy is final
}

/**
 * Abstract classes
 */
abstract class Mammal(val birthdate: String) {
    abstract fun consumeFood()
}

class Human(birthdate: String): Mammal(birthdate) {
    override fun consumeFood() {
        TODO("Not yet implemented")
    }

    fun createBirthCertificate() {

    }
}
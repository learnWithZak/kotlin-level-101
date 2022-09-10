package m_classes

import java.util.Random


fun main() {
    class SimplePerson(val name: String)

    class Person(var firstName: String, var lastName: String) {
        var fullName = "$firstName $lastName"
    }

    var var1 = SimplePerson("John")
    // the var1 doesn't store the instance itself, but a reference (memory address) to the instance
    var var2 = var1

    /**
     * Working with references
     */

    val john = Person(firstName = "Johnny", lastName = "Appleseed")
    var homeOwner = john
    john.firstName = "John"

    println(john.firstName)
    println(homeOwner.firstName)

    /**
     * Object identity
     */
    val impostorJohn = Person(firstName = "John", lastName = "Appleseed")
    println(homeOwner === john)
    println(john === impostorJohn)
    println(impostorJohn === homeOwner)

    homeOwner = impostorJohn
    println(john === homeOwner)

    homeOwner = john
    println(john === homeOwner)

    var imposters = (0..100).map {
        Person(firstName = "John", lastName = "Appleseed")
    }

    val isValueEqual = imposters.map {
        it.firstName == "John" && it.lastName == "Appleseed"
    }.contains(true)

    println(isValueEqual)

    println(imposters.contains(john))

    // now, we can hide the real john between the imposters
    val mutableImposters = mutableListOf<Person>()
    mutableImposters.addAll(imposters)
    mutableImposters.contains(john)
    mutableImposters.add(Random().nextInt(5), john)
    println(mutableImposters.contains(john))

    val indexOfJohn = mutableImposters.indexOf(john)
    if (indexOfJohn != -1) {
        mutableImposters[indexOfJohn].lastName = "Bananapeel"
    }
    println(john.fullName)

    /**
     * Mini-exercise
     */
    fun memberOf(person: Person, group: List<Person>): Boolean {
        return group.contains(person)
    }

    val group1 = listOf(
        Person("tott","titi"),
        Person("totr","titi"),
        john,
        Person("totz","titi"),
        Person("tota","titi")
    )

    val group2 = listOf(
        Person("qott","titi"),
        Person("wotr","titi"),
        Person("xote","titi"),
        Person("eotz","titi"),
        Person("rota","titi")
    )

    println(memberOf(john, group1))
    println(memberOf(john, group2))

    /**
     * Methods and mutability
     */
    class Grade(
        val letter: String,
        val points: Double,
        val credits: Double
    )

    class Student(
        val firstName: String,
        val lastName: String,
        val grades: MutableList<Grade> = mutableListOf(),
        var credits: Double = 0.0
    ) {
        val gpa: Double
            get() {
            var gpa = 0.0
            for (grade in grades) {
                gpa += grade.points / credits
            }
            return gpa
        }
        fun recordGrade(grade: Grade) {
            grades.add(grade)
            credits += grade.credits
        }
    }

    val jane = Student(firstName = "Jane", lastName = "Appleseed")
    val history = Grade(letter = "B", points = 9.0, credits = 3.0)
    var math = Grade(letter = "A", points = 16.0, credits = 4.0)

    jane.recordGrade(history)
    jane.recordGrade(math)

    /**
     * Mutability and constants
     */
    // jane = Student("toto", "titi") //build error

    /**
     * Mini-exercise
     */
    println(jane.gpa.toFloat())

    /**
     * Understanding state and side effects
     */
    println(jane.credits)
    // the teacher made a mistake, math has 5 credits
    math = Grade(letter = "A", points = 20.0, credits = 5.0)
    jane.recordGrade(math)
    println(jane.credits) // 12 instead of 8 !
}
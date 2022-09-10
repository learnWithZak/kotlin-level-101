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
}
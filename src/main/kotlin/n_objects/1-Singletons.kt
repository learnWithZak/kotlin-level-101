package n_objects

object X {
    var x = 0
}

data class Student(
    val id: Int,
    val firstName: String,
    val lastName: String
) {
    val fullName = "$lastName, $firstName"
}

fun main() {
    val marie = Student(1, "Marie", "Curie")
    val albert = Student(2, "Albert", "Einstein")
    val emmy = Student(3, "Emmy", "Noether")
    StudentRegistry.addStudent(marie)
    StudentRegistry.addStudent(albert)
    StudentRegistry.addStudent(emmy)
    StudentRegistry.listAllStudents()
}

object StudentRegistry {
    val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student) {
        allStudents.add(student)
    }

    fun removeStudent(student: Student) {
        allStudents.remove(student)
    }

    fun listAllStudents() {
        allStudents.forEach {
            println(it.fullName)
        }
    }
}

object JsonKeys {
    const val JSON_KEY_ID = "id"
    const val JSON_KEY_FIRSTNAME = "first_name"
    const val JSON_KEY_LASTNAME = "last_name"
}
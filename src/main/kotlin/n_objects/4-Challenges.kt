package n_objects

fun main() {
    println(Threshold.isAboveThreshold(4))
    val studentMap = mapOf("first_name" to "Neils", "last_name" to "Bohr")
    val student = NewStudent.loadStudent(studentMap)
    println(student)

    val thresholdChecker = object : ThresholdChecker {
        override val lower: Int
            get() = 7
        override val upper: Int
            get() = 10

        override fun isLit(value: Int): Boolean {
            return value > upper
        }

        override fun tooQuiet(value: Int): Boolean {
            return value < lower
        }

    }

    if (thresholdChecker.isLit(11)) {
        println("That's what we do.")
    } else {
        println("Where can you go from there?")
    }

    if (thresholdChecker.tooQuiet(6)) {
        println("OK.")
    } else {
        println("Where can you go from there?")
    }
}

object Threshold {
    fun isAboveThreshold(value: Int): Boolean {
        return value > 10
    }
}

data class NewStudent private constructor(
    val firstName: String,
    val lastName: String
) {
    companion object {
        fun loadStudent(studentMap: Map<String, String>): NewStudent {
            val firstName = studentMap["first_name"] ?: "First"
            val lastName = studentMap["last_name"] ?: "Last"
            return NewStudent(firstName, lastName)
        }
    }
}

interface ThresholdChecker {
    val lower: Int
    val upper: Int

    /**
     * Returns true if value is higher than the upper threshold
     * and false otherwise
     */
    fun isLit(value: Int): Boolean
    /**
     * Returns true if value is less than the lower threshold
     * and false otherwise
     */
    fun tooQuiet(value: Int): Boolean
}
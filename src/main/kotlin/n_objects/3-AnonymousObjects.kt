package n_objects

interface Counts {
    fun studentCount(): Int
    fun scientistCount(): Int
}

fun main() {
    val counter = object : Counts {
        override fun studentCount(): Int {
            return StudentRegistry.allStudents.size
        }

        override fun scientistCount(): Int {
            return ScientistRepository.allScientists.size
        }
    }
    println(counter.studentCount())
    println(counter.scientistCount())
}
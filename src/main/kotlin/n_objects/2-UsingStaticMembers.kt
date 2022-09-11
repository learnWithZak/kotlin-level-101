package n_objects

fun main() {
    val emmy = Scientist.newScientist("Emmy", "Noether")
    val isaac = Scientist.newScientist("Isaac", "Newton")
    val nick = Scientist.newScientist("Nikola", "Tesla")

    ScientistRepository.addScientist(emmy)
    ScientistRepository.addScientist(isaac)
    ScientistRepository.addScientist(nick)

    ScientistRepository.listAllScientists()

}

class Scientist private constructor(
    val id: Int,
    val firstName: String,
    val lastName: String
) {
    companion object {
        var currentId = 0

        fun newScientist(firstName: String, lastName: String): Scientist {
            currentId += 1
            return Scientist(currentId, firstName, lastName)
        }
    }

    var fullName = "$firstName $lastName"
}

object ScientistRepository {
    val allScientists = mutableListOf<Scientist>()

    fun addScientist(scientist: Scientist) {
        allScientists.add(scientist)
    }

    fun removeScientist(scientist: Scientist) {
        allScientists.remove(scientist)
    }

    fun listAllScientists() {
        allScientists.forEach {
            println("${it.id}: ${it.fullName}")
        }
    }
}
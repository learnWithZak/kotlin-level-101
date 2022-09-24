package w_conventionsAndOperatorOverloading

class Company(val name: String) {
    private val departments = arrayListOf<Department>()

    operator fun plusAssign(department: Department) {
        departments.add(department)
    }

    operator fun minusAssign(department: Department) {
        departments.remove(department)
    }
}
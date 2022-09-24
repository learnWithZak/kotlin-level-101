package w_conventionsAndOperatorOverloading

class Company(val name: String) {
    private val departments = arrayListOf<Department>()
    val allEmployees: List<Employee>
        get() = arrayListOf<Employee>().apply {
            departments.forEach { addAll(it.employees) }
            sort()
        }

    operator fun plusAssign(department: Department) {
        departments.add(department)
    }

    operator fun minusAssign(department: Department) {
        departments.remove(department)
    }
}
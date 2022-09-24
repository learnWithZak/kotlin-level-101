package w_conventionsAndOperatorOverloading

class Department(val name: String): Iterable<Employee> {
    val employees = arrayListOf<Employee>()

    operator fun plusAssign(employee: Employee) {
        employees.add(employee)
        println("${employee.name} hired to $name department")
    }

    operator fun minusAssign(employee: Employee) {
        if (employees.contains(employee)) {
            employees.remove(employee)
            println("${employee.name} fired from $name department")
        }
    }

    operator fun get(index: Int): Employee? {
        return if (index < employees.size) employees[index] else null
    }

    operator fun set(index: Int, employee: Employee) {
        if (index < employees.size) employees[index] = employee
    }

    operator fun contains(employee: Employee): Boolean {
        return employees.contains(employee)
    }

    override fun iterator(): Iterator<Employee> {
        return employees.iterator()
    }
}
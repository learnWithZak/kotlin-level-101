package w_conventionsAndOperatorOverloading

class Department(val name: String) {
    private val employees = arrayListOf<Employee>()

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
}
package w_conventionsAndOperatorOverloading

fun main() {

    /**
     * operator overloading
     */
    val company = Company("MyOwnCompany")

    // departments
    val developmentDepartment = Department("Development")
    val qaDepartment = Department("Quality Assurance")
    val hrDepartment = Department("Human Resources")

    // employees
    var Julia = Employee(company, "Julia", 100_000)
    var John = Employee(company, "John", 86_000)
    var Peter = Employee(company, "Peter", 100_000)

    var Sandra = Employee(company, "Sandra", 75_000)
    var Thomas = Employee(company, "Thomas", 73_000)
    var Alice = Employee(company, "Alice", 70_000)

    var Bernadette = Employee(company, "Bernadette", 66_000)
    var Mark = Employee(company, "Mark", 66_000)

    ++Julia
    println(Julia.salary)

    --Peter
    println(Peter.salary)

    Mark += 2500
    Alice -= 2000

    company += developmentDepartment
    company += qaDepartment
    company += hrDepartment

    developmentDepartment += Julia
    developmentDepartment += John
    developmentDepartment += Peter

    qaDepartment += Sandra
    qaDepartment += Thomas
    qaDepartment += Alice

    hrDepartment += Bernadette
    hrDepartment += Mark

    qaDepartment -= Thomas
}
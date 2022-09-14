package p_methods

fun main() {
    val months = arrayOf(
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"
    )

    class SimpleDate(var month: String)

    fun monthsUntilWinterBreak(from: SimpleDate): Int {
        return months.indexOf("December") - months.indexOf(from.month)
    }

    println(monthsUntilWinterBreak(SimpleDate("September")))

    // OTHER WAY
    class SimpleDate2(var month: String) {
        fun monthsUntilWinterBreak(from: SimpleDate2): Int {
            return months.indexOf("December") - months.indexOf(from.month)
        }
    }

    val date2 = SimpleDate2("September")
    println(date2.monthsUntilWinterBreak(date2))

    /**
     * Introducing this
     */
    class SimpleDate3(var month: String) {
        fun monthsUntilWinterBreak(): Int {
            return months.indexOf("December") - months.indexOf(this.month) // you can remove 'this'
        }
    }

    val date3 = SimpleDate3("September")
    println(date3.monthsUntilWinterBreak())

    /**
     * Mini-exercise
     */

    class SimpleDate4(var month: String) {
        val monthsUntilWinterBreak: Int
            get() = months.indexOf("December") - months.indexOf(month)
    }

    val date4 = SimpleDate4("September")
    println(date4.monthsUntilWinterBreak)
}
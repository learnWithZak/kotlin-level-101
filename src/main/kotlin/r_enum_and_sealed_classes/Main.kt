package r_enum_and_sealed_classes

import java.util.Calendar

enum class DayOfTheWeek(val isWeekend: Boolean = false) {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true),
    Sunday(true);

    fun daysUntil(other: DayOfTheWeek): Int {
        return if (this.ordinal < other.ordinal) {
            other.ordinal - this.ordinal
        } else {
            other.ordinal - this.ordinal + DayOfTheWeek.values().count()
        }
    }

    companion object {
        fun today(): DayOfTheWeek {
            val calendarDayOfTheWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            println("current day ordinal: $calendarDayOfTheWeek")
            var adjustedDay = calendarDayOfTheWeek - 2
            println("adjusted day: $adjustedDay")
            val days = DayOfTheWeek.values()
            if (adjustedDay < 0) {
                adjustedDay += days.count()
            }
            val today = days.first { it.ordinal == adjustedDay }
            return today
        }
    }
}

fun main() {
    for (day in DayOfTheWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
    }

    val dayIndex = 0
    val dayAtIndex = DayOfTheWeek.values()[dayIndex]
    println("Day at $dayIndex is $dayAtIndex")

    val tuesday = DayOfTheWeek.valueOf("Tuesday")
    println("Tuesday is day ${tuesday.ordinal}")

    // val notADay = DayOfTheWeek.valueOf("brewDay")
    //println("Not a day: $notADay") // IllegalArgumentException

    val today = DayOfTheWeek.today()
    val isWeekend = "it is${if(today.isWeekend) "" else " not"} the weekend"
    println("it is $today. $isWeekend")

    val secondDay = DayOfTheWeek.Friday
    val daysUntil = today.daysUntil(secondDay)
    println("It is $today. $isWeekend. There are $daysUntil days until $secondDay.")
}
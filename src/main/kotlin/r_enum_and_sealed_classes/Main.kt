package r_enum_and_sealed_classes

enum class DayOfTheWeek {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;
}

fun main() {
    for (day in DayOfTheWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}")
    }

    val dayIndex = 0
    val dayAtIndex = DayOfTheWeek.values()[dayIndex]
    println("Day at $dayIndex is $dayAtIndex")

    val tuesday = DayOfTheWeek.valueOf("Tuesday")
    println("Tuesday is day ${tuesday.ordinal}")

    // val notADay = DayOfTheWeek.valueOf("brewDay")
    //println("Not a day: $notADay") // IllegalArgumentException
}
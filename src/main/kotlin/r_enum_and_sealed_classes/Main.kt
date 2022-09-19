package r_enum_and_sealed_classes

import java.util.Calendar

sealed class AcceptedCurrency {
    abstract val valueInDollar: Float
    var amount: Float = 0.0f

    class Dollar: AcceptedCurrency() {
        override val valueInDollar: Float
            get() = 1.0f

    }
    class Euro: AcceptedCurrency() {
        override val valueInDollar: Float
            get() = 1.25f

    }
    class Crypto: AcceptedCurrency() {
        override val valueInDollar: Float
            get() = 2534.99f

    }

    val name: String
        get() = when (this) {
            is Euro -> "Euro"
            is Dollar -> "Dollars"
            is Crypto -> "NerdCoin"
        }

    fun totalValueInDollars(): Float {
        return amount * valueInDollar
    }
}
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

    when (today) {
        DayOfTheWeek.Monday -> println("I don't care if $today's blue")
        DayOfTheWeek.Tuesday -> println("$today's gray")
        DayOfTheWeek.Wednesday -> println("And $today, too")
        DayOfTheWeek.Thursday -> println("$today, I don't care 'bout you")
        DayOfTheWeek.Friday -> println("It's $today, I'm in love")
        DayOfTheWeek.Saturday -> println("$today, Wait...")
        DayOfTheWeek.Sunday -> println("$today always comes too late")
    }

    /**
     * Sealed vs Enum
     */
    val currency = AcceptedCurrency.Crypto()
    println("You've got some ${currency.name}")
    currency.amount = .27541f
    println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars")

    Downloader().downloadData("foo.com/bar",
    progress = { state ->
        when (state) {
            DownloadState.Idle -> println("Download has not yet started.")
            DownloadState.Starting -> println("Starting download...")
            DownloadState.InProgress -> println("Downloading data...")
            DownloadState.Error -> println("An error occurred. Download terminated.")
            DownloadState.Success -> println("Download completed successfully.")
        }
    },
    completion = { error, data ->
        error?.let { println("Got error: ${error.message}") }
        data?.let { println("Got list with ${data.size} items") }
    })
}
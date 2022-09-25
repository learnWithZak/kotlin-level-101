package x_coroutines

class Building(val name: String) {

    fun makeFoundation() {
        Thread.sleep(300)
        speakThroughBullhorn("The foundation is ready")
    }

    fun buildFloor(floor: Int) {
        Thread.sleep(100)
        speakThroughBullhorn("The $floor'th floor is raised")
    }

    fun placeWindows(floor: Int) {
        Thread.sleep(100)
        speakThroughBullhorn("Windows are placed on the $floor'th floor")
    }

    fun installDoors(floor: Int) {
        Thread.sleep(100)
        speakThroughBullhorn("Doors are installed on the $floor'th floor")
    }

    fun provideElectricity(floor: Int) {
        Thread.sleep(100)
        speakThroughBullhorn("Electricity is provided on the $floor'th floor")
    }

    fun buildRoof() {
        Thread.sleep(200)
        speakThroughBullhorn("The roof is ready")
    }

    fun fitOut(floor: Int) {
        Thread.sleep(200)
        speakThroughBullhorn("The $floor'th floor is furnished")
    }

    fun speakThroughBullhorn(message: String) = println(message)

}

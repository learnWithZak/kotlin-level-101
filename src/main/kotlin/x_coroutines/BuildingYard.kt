package x_coroutines

object BuildingYard {

    fun startProject(name: String, floors: Int) {
        val startTime = System.currentTimeMillis()
        val building = Building(name)

        building.speakThroughBullhorn("$name is started")
        building.makeFoundation()

        (1 until floors).forEach {
            building.buildFloor(it)
            building.placeWindows(it)
            building.installDoors(it)
            building.provideElectricity(it)
            building.fitOut(it)
        }

        building.buildRoof()

        building.speakThroughBullhorn("${building.name} is ready in ${System.currentTimeMillis() - startTime}!")
    }

}

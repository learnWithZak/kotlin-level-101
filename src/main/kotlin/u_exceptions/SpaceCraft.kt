package u_exceptions

import java.lang.Exception

class SpaceCraft {

    private var isConnectionAvailable = false
    private var isEngineInOrder = false
    private var fuel = 0
    var isInSpace = false

    fun launch() {
        if (fuel < 5) {
            throw Exception("out of fuel. Can't take off")
            //sendMessageToEarth("out of fuel. Can't take off")
            //return
        }

        if (!isEngineInOrder) {
            throw Exception("The engine is broken. Can't take off")
            //sendMessageToEarth("The engine is broken. Can't take off")
            //return
        }

        if (!isConnectionAvailable) {
            throw Exception("No connection with earth. can't take off")
            //sendMessageToEarth("No connection with earth. can't take off")
            //return
        }

        sendMessageToEarth("Trying to launch...")
        fuel -= 5
        sendMessageToEarth("I'm in space")
        sendMessageToEarth("I've found some extraterrestrials")
        isInSpace = true
    }

    private fun sendMessageToEarth(message: String) {
        println("Spacecraft to Earth: $message")
    }
}

object SpacePort {
    fun investigateSpace(spaceCraft: SpaceCraft) {
        spaceCraft.launch()
    }
}
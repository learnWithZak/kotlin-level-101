package u_exceptions

import u_exceptions.exception.BrokenEngineException
import u_exceptions.exception.OutOfFuelException
import u_exceptions.exception.SpaceToEarthConnectionFailedException
import java.lang.Exception

class SpaceCraft {

    private var isConnectionAvailable = false
    private var isEngineInOrder = false
    private var fuel = 0
    var isInSpace = false

    fun launch() {
        if (fuel < 5) {
            throw OutOfFuelException()
            //sendMessageToEarth("out of fuel. Can't take off")
            //return
        }

        if (!isEngineInOrder) {
            throw BrokenEngineException()
            //sendMessageToEarth("The engine is broken. Can't take off")
            //return
        }

        if (!isConnectionAvailable) {
            throw SpaceToEarthConnectionFailedException()
            //sendMessageToEarth("No connection with earth. can't take off")
            //return
        }

        sendMessageToEarth("Trying to launch...")
        fuel -= 5
        sendMessageToEarth("I'm in space")
        sendMessageToEarth("I've found some extraterrestrials")
        isInSpace = true
        throw AliensAttackException()
    }

    fun overhaul() {
        if (fuel < 5) {
            refuel()
        }

        if (!isEngineInOrder) {
            repairEngine()
        }

        if (!isConnectionAvailable) {
            fixConnection()
        }
    }

    fun refuel() {
        fuel += 5
        sendMessageToEarth("The fuel tank is filled")
    }

    fun repairEngine() {
        isEngineInOrder = true
        sendMessageToEarth("The engine is in order")
    }

    fun fixConnection() {
        isConnectionAvailable = true
        sendMessageToEarth("Hello Earth! can you hear me ?")
        sendMessageToEarth("Connection is established")
    }

    fun land() {
        sendMessageToEarth("Landing...")
        isInSpace = false
    }

    fun sendMessageToEarth(message: String) {
        println("Spacecraft to Earth: $message")
    }
}

object SpacePort {
    fun investigateSpace(spaceCraft: SpaceCraft) {
        try {
            spaceCraft.launch()
        } catch (exception: SpaceCraftException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.overhaul()
        } catch (exception: AliensAttackException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
        } finally {
            if (spaceCraft.isInSpace) {
                spaceCraft.land()
            } else {
                investigateSpace(spaceCraft)
            }
        }
    }

    fun testSetup(spaceCraft: SpaceCraft) = try {
        spaceCraft.launch()
        true
    } catch (exception: SpaceCraftException) {
        false
    } finally {
        spaceCraft.land()
    }
}

open class SpaceCraftException(message: String): Exception(message)

class AliensAttackException: Exception("SOS ! Oh aliens attack us!!")
package r_enum_and_sealed_classes

import java.util.*
import kotlin.concurrent.timerTask
import kotlin.system.exitProcess

enum class DownloadState {
    Idle,
    Starting,
    InProgress,
    Error,
    Success
}

class Downloader {

    private val maxData = 100
    var downloadState: DownloadState = DownloadState.Idle
    private var fakeData: MutableList<Int> = mutableListOf()

    fun downloadData(fromUrl: String, progress: (state: DownloadState) -> Unit, completion: (error: Error?, data: List<Int>?) -> Unit) {
        println("\"Downloading\" from URL: ${fromUrl}")
        postProgress(progress)
        downloadState = DownloadState.Starting
        keepAddingData(completion)
    }

    private fun keepAddingData(completion: (error: Error?, data: List<Int>?) -> Unit) {
        addMoreData { error ->
            when (downloadState) {
                DownloadState.Error -> completion(error, null)
                DownloadState.Success -> completion(null, fakeData.toList())
                else -> keepAddingData(completion)
            }
        }
    }

    private fun postProgress(progress: (state: DownloadState) -> Unit) {
        progress(downloadState)

        when (downloadState) {
            DownloadState.Error -> exitProcess(1)
            DownloadState.Success -> exitProcess(0)
            else -> Timer().schedule(timerTask { postProgress(progress) }, 200)
        }
    }

    private fun addMoreData(completion: (error: Error?) -> Unit) {
        Timer().schedule(timerTask {
            val error = randomlyThrowError()
            if (error != null) {
                downloadState = DownloadState.Error
                completion(error)
            } else {
                downloadState = DownloadState.InProgress
                for (i in 0..20) {
                    fakeData.add(i)
                    if (fakeData.size == maxData) {
                        downloadState = DownloadState.Success
                        break
                    }
                }

                completion(null)
            }
        }, 500)
    }

    private fun randomlyThrowError(): Error? {
        val randomNumber: Int = (0..10).random()
        if (randomNumber == 8) {
            return Error("Your download was eaten by a shark.")
        } else {
            return null
        }
    }
}

// Via https://stackoverflow.com/a/45687695/681493
fun ClosedRange<Int>.random() =
    Random().nextInt(endInclusive - start) + start
package x_coroutines

import kotlin.concurrent.thread

fun main() {
    thread(start = true, name = "another thread") {
        (0..10).forEach {
            println("Message $it from the ${Thread.currentThread().name}")
        }
    }

    (0..10).forEach {
        println("Message $it from the ${Thread.currentThread().name}")
    }
}
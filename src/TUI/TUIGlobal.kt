package TUI

import kotlin.system.exitProcess

internal fun terminate() {
    print("Are you sure to exit (y/N)? ")
    when(readlnOrNull()) {
        "y" -> {
            println("Halting")
            exitProcess(0)
        }
        else -> println("Aborting quit")
    }
    println("Exiting")
}
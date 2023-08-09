package TUI

class AddEntry(private var args: List<String>) {
    init {
        isInteractive()
    }

    private fun isInteractive() {

        if (args.isEmpty()) { // MARK: Switch to interactive mode
            interactiveMode()
            return
        }

        when (args.first()) {
            "entry" -> {
                args = args.subList(1, args.size)
                createEntryMode()
            }
            "station" -> println("Adding a new station")
            "location" -> println("Adding a new location")
            else -> println("NotImplementedException")
        }
    }

    private fun interactiveMode() {
        print("Item to create ?> ")

        val input = readlnOrNull()?.split(" ")
        val modeSel = input?.first()

        when(modeSel) {
            "entry" -> createEntryMode()
            "help" -> help()
            "exit" -> return // MARK: Exit condition for recursive method
            "quit" -> terminate()
            else -> {
                println("Argument not found")
                help()
            }
        }

        interactiveMode()
    }

    private fun createEntryMode() {
        println("Creating new entry")
    }

    private fun help() {
        println("help me!!")
    }
}
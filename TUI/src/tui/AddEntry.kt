package tui

import handlers.DataHandler

class AddEntry(private var args: List<String>, private val dataHandler: DataHandler) {

    private var isInteractiveMode: Boolean = false

    init {
        addModelSel()
    }

    private fun addModelSel() {

        if (args.isEmpty()) { // MARK: Switch to interactive mode
            isInteractiveMode = true
            interactiveMode()
            return
        }

        isInteractiveMode = false

        createModeSel(args.first())
    }

    private fun interactiveMode() {
        print("Item to add ?> ")

        val input = readlnOrNull()?.split(" ")
        when(val modeSel = input?.first()) {
            "exit" -> return // MARK: Exit condition for recursive method
            "quit" -> terminate()
            else -> createModeSel(modeSel)
        }

        interactiveMode()
    }

    private fun createModeSel(modeSelArgs: String?) {
        when(modeSelArgs) {
            "entry" -> {
                if (!args.isEmpty())
                    args = args.subList(1, args.size)

                createEntryMode()
            }
            "station" -> createStationMode()
            "location" -> createLocationMode()
            "help" -> addHelp()
            "?" -> addHelp()
            else -> {
                println("Argument not found")
                addHelp()
            }
        }
    }

    private fun createEntryMode() {
        // TODO: Implement add entry function

        if (args.isEmpty()) {
            println("Creating new entry")

            print("date (YYYY-MM-DD): ") // will be today if empty
            val dateInput = readlnOrNull()

            print("station [{your last station}]: ")
            val stationInput = readlnOrNull()

            print("location [{your last location}]: ")
            val locationInput = readlnOrNull()

            print("task: ")
            val taskInput = readlnOrNull()

            println("Successfully added your entry")

            print("Created new task for today with following entry: ")
            println(taskInput)

            dataHandler.createEntry()

            return
        }

        dataHandler.createEntry()
        print("Created new task for today with following entry: ")
        println(args.first())

    }

    private fun createStationMode() {
        // TODO: Implement add station function
        println("Adding a new station")
    }

    private fun createLocationMode() {
        // TODO: Implement add location function
        println("Adding a new location")
    }

    private fun addHelp() {
        println("====")
        println("Add help page - available commands")
        println("====")

        println("entry: Add a new entry")
        println("station: Add a new work station")
        println("location: Add a new work location")

        println("help: Display this message")
        println("?: Same as help")

        if (isInteractiveMode) {
            println("exit: Exit the current mode")
            println("quit: Quit the application")
        }

        println("====")
    }
}
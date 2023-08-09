package TUI

class AddEntry(private var args: List<String>) {

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
            "entry" -> createEntryMode()
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
        println("Creating new entry")
    }

    private fun createStationMode() {
        // TODO: Implement add station function
    }

    private fun createLocationMode() {
        // TODO: Implement add location function
    }

    private fun addHelp() {
        // TODO: Implement add help function

        println("help me!!")
    }
}
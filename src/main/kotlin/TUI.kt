class TUI {

    init {
        startupMessage()
        tui()
    }

    private fun startupMessage() {
        println("Starting tui")
    }
    private fun tui() {
        print("?> ")

        //
        // which commands should be supported:
        // help: print all available commands
        // add: add a new entry
        // create: create a new printout
        // print / export: same as create
        // show: show all entries in a table
        //

        when (readlnOrNull()) {
            "?" -> help()
            "help" -> help() // TODO: Create help page
            "add" -> println("Adding new element")
            "settings" -> println("Settings page")
            "clear" -> println("Clearing the interface")
            "exit" -> return // MARK: Break condition for recursion!
            else -> {
                println("Command not known")
                help()
            }
        }
        tui()
    }
    private fun help() {
        println("Help")
    }
}
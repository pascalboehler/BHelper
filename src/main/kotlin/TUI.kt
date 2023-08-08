class TUI {

    init {
        println("Starting TUI")
        start()
    }
    private fun start() {
        while (true) {
            print("?> ")

            //
            // which commands should be supported:
            // help: print all available commands
            // add: add a new entry
            // create: create a new printout
            // print / export: same as create
            // show: show all entries in a table
            //

            when (val input = readlnOrNull()) {
                "?" -> help()
                "help" -> help() // TODO: Create help page
                "add" -> println("Adding new element")
                "settings" -> println("Settings page")
                "clear" -> println("Clearing the interface")
                "exit" -> break
                else -> {
                    println("Command not known")
                    help()
                }
            }
        }
    }
    private fun help() {
        println("Help")
    }
}
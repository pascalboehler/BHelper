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
            "print" -> println("Initializing print")
            "exit" -> return // MARK: Break condition for recursion!
            else -> {
                println("Command not known")
                help()
            }
        }
        tui()
    }

    // TODO: Implement add command
    private fun add() {
        println("Adding a new element")
    }

    // TODO: Implement print command
    private fun print() {
        println("")
    }

    // TODO: Implement show command
    private fun show() {

    }

    // TODO: Implement importer
    private fun import() {

    }

    // TODO: Implement signing
    private fun sign() {

    }

    // TODO: Implement settigns
    private fun settings() {

    }

    private fun help() {
        println("BHelper v0.1")
        println("====")
        println("Help page - available commands")
        println("====")
        println("help: Shows this help message")
        println("add: Create a new entry")
        println("print: Generate printout for specified week")
        println("show: Show all stored entries")
        println("import: Import template or data from file")
        println("sign: Send your Berichtsheft to your predefined signing provider")
        println("settings: Change the settings of this app")
        println("====")
    }
}

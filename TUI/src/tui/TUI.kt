package tui

import handlers.DataHandler

class TUI {

    private val dataHandler: DataHandler = DataHandler()

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

        val input = readlnOrNull()?.split(" ")

        when (input?.first()) {
            "?" -> help()
            "help" -> help() // TODO: Create help page
            "add" -> {
                AddEntry(input.subList(1, input.size), dataHandler)
            }
            "settings" -> settings()
            "clear" -> clear()
            "print" -> print()
            "show" -> show()
            "import" -> import()
            "sign" -> sign()
            "exit" -> return // MARK: Break condition for recursion!
            "quit" -> terminate()
            "" -> {} // do nothing just go on
            else -> {
                println("Command not known\n")
                help()
            }
        }
        tui()
    }

    // TODO: Implement print command
    private fun print() {
        println("Printing")
    }

    // TODO: Implement show command
    private fun show() {
        println("Show")
    }

    // TODO: Implement importer
    private fun import() {
        println("Import")
    }

    // TODO: Implement signing
    private fun sign() {
        println("Sign")
    }

    // TODO: Implement settings
    private fun settings() {
        println("Settings")
    }

    // TODO: Implement clear
    private fun clear() {
        println("Clearing")
    }

    private fun help() {
        println("BHelper v0.1")
        println("====")
        println("Help page - available commands")
        println("====")
        println("help, ?: Shows this help message")
        println("add: Create a new entry")
        println("print: Generate printout for specified week")
        println("show: Show all stored entries")
        println("import: Import template or data from file")
        println("sign: Send your Models.Berichtsheft to your predefined signing provider")
        println("clear: Clean up the prompt")
        println("settings: Change the settings of this app")
        println("====")
    }
}

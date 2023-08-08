fun main() {
    println("Hello World!")

    val tui = TUI()
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    while (true) {
        print("> ")

        //
        // which commands should be supported:
        // help: print all available commands
        // add: add a new entry
        // create: create a new printout
        // print / export: same as create
        // show: show all entries in a table
        //

        when (val input = readlnOrNull()) {
            "?" -> tui.help()
            "help" -> tui.help() // TODO: Create help page
            "add" -> println("Adding new element")
            "settings" -> println("Settings page")
            "clear" -> println("Clearing the interface")
            "exit" -> break
            else -> {
                println("Command not known")
                tui.help()
            }
        }
    }
}
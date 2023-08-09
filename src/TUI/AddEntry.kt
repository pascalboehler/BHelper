package TUI

class AddEntry(private var args: List<String>) {
    init {
        println("Hi")
        for (arg in args) {
            println(arg)
        }

        when (args.first()) {
            "entry" -> println("Adding a new entry")
            "station" -> println("Adding a new station")
            "location" -> println("Adding a new location")
            else -> println("NotImplementedException")
        }
    }
}
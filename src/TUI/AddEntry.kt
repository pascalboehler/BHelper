package TUI

class AddEntry(val args: List<String>) {
    init {
        println("Hi")
        for (arg in args) {
            println(arg)
        }
    }
}
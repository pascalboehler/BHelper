package TUI

class AddEntry(private val args: List<String>) {
    init {
        println("Hi")
        for (arg in args) {
            println(arg)
        }
    }
}
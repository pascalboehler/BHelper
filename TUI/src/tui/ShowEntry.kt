package tui

import handlers.DataHandler

internal class ShowEntry(var args: List<String>, val dataHandler: DataHandler) {

    private var isInteractiveMode: Boolean = false

    init {
        showModeSel()
    }

    private fun showModeSel() {
        if (args.isEmpty()) {
            isInteractiveMode = true
            interactiveMode()
            return
        }

        isInteractiveMode = false

        modeSel(args.first())

    }

    private fun interactiveMode() {
        while (true) {
            print("show ?> ")

            when (val input = readlnOrNull()) {
                "exit" -> break
                "quit" -> terminate()
                "" -> continue
                else -> modeSel(input)
            }
        }
    }

    private fun modeSel(args: String?) {
        when(args) {
            "help" -> help()
            "?" -> help()
            "task" -> showTask()
            else -> {
                println("Command unknown")
                help()
            }
        }
    }

    private fun showTask() {
        println("Task")
    }

    private fun help() {
        println("help me!")
    }
}
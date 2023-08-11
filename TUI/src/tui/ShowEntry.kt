package tui

import handlers.DataHandler

internal class ShowEntry(private var args: List<String>?, private val dataHandler: DataHandler) {

    private var isInteractiveMode: Boolean = false

    init {
        showModeSel()
    }

    private fun showModeSel() {
        if (args?.isEmpty() == true) {
            isInteractiveMode = true
            interactiveMode()
            return
        }

        isInteractiveMode = false

        modeSel(args?.first())

    }

    private fun interactiveMode() {
        while (true) {
            print("show ?> ")

            val input = readlnOrNull()

            val inputList = input?.split(" ")

            args = inputList

            when (val mode = args?.first()) {
                "exit" -> break
                "quit" -> terminate()
                "" -> continue
                else -> modeSel(mode)
            }
        }
    }

    private fun modeSel(mode: String?) {

        when(mode) {
            "help" -> help()
            "?" -> help()
            "task" -> {
                if (args?.isEmpty() == false)
                    args = args?.size?.let { args?.subList(1, it) }

                showTask()
            }
            "station" -> showStation()
            "pic" -> showPic()
            "location" -> showLocation()
            "all" -> showAll()
            "." -> showAll()
            else -> {
                println("Command unknown")
                help()
            }
        }
    }

    private fun showTask() {
        if (args?.isEmpty() == true) {
        } else {
            println(args?.first())
        }
        println("Task")
    }

    private fun showStation() {
        println("Station")
    }

    private fun showPic() {
        println("Person in charge")
    }

    private fun showLocation() {
        println("Location")
    }

    private fun showAll() {
        showTask()
        showLocation()
        showStation()
        showPic()
    }

    private fun help() {
        println("help me!")
    }
}
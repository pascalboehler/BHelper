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

        if (args?.isEmpty() == false)
            args = args?.size?.let { args?.subList(1, it) }

        when(mode) {
            "help" -> help()
            "?" -> help()
            "task" -> showTask()
            "station" -> showStation()
            "pic" -> showPic()
            "location" -> showAll()
            "." -> showAll()
            else -> {
                println("Command unknown")
                help()
            }
        }
    }

    private fun showTask(getAll: Boolean = false) {
        if (args?.isEmpty() == true || getAll || args?.first().equals("all") || args?.first().equals(".")) {
            println("Fetching all data")
        } else {
            println(args?.first())
        }
        println("Task")
    }

    private fun showStation(getAll: Boolean = false) {
        if (args?.isEmpty() == true || getAll || args?.first().equals("all") || args?.first().equals(".")) {
            println("Fetching all data")
        } else {
            println(args?.first())
        }
        println("Station")
    }

    private fun showPic(getAll: Boolean = false) {
        if (args?.isEmpty() == true || getAll || args?.first().equals("all") || args?.first().equals(".")) {
            println("Fetching all data")
        } else {
            println(args?.first())
        }
        println("Person in charge")
    }

    private fun showLocation(getAll: Boolean = false) {
        if (args?.isEmpty() == true || getAll || args?.first().equals("all") || args?.first().equals(".")) {
            println("Fetching all data")
        } else {
            println(args?.first())
        }
        println("Location")
    }

    private fun showAll() {
        showTask(true)
        showLocation(true)
        showStation(true)
        showPic(true)
    }

    private fun help() {
        println("====")
        println("Show help page - available commands")
        println("====")

        println("task [all / . / {task_id}]: Show all tasks or selected task")
        println("station [all / . / {station_id}]: Show all or selected station")
        println("location [all / . / {station_id}]: Show all or selected location")

        println("help, ?: Display this message")
        if (isInteractiveMode) {
            println("exit: Exit the current mode")
            println("quit: Quit the application")
        }

        println("====")
    }
}
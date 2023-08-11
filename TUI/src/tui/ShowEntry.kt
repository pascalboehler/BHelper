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
            "station" -> {
                if (args?.isEmpty() == false)
                    args = args?.size?.let { args?.subList(1, it) }

                showStation()
            }
            "pic" -> {
                if (args?.isEmpty() == false)
                    args = args?.size?.let { args?.subList(1, it) }

                showPic()
            }
            "location" -> {
                if (args?.isEmpty() == false)
                    args = args?.size?.let { args?.subList(1, it) }

                showLocation()
            }
            "all" -> {
                if (args?.isEmpty() == false)
                    args = args?.size?.let { args?.subList(1, it) }

                showAll()
            }
            "." -> {
                if (args?.isEmpty() == false)
                    args = args?.size?.let { args?.subList(1, it) }

                showAll()
            }
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
        println("help me!")
    }
}
package handlers

class DataHandler {

    private val baseURL = "{baseurl}" // the base url; later will be set by .env file
    private val apiKey = "{API_KEY}" //  the API Key, will be set by .env file later

    init {
        helloWorld()
    }

    private fun helloWorld() {
        println("I AM ALIVE")
    }

    fun createEntry() {
        println("Hello")
    }
}
package handlers

class DataHandler {

    private val baseURL = "{baseurl}" // the base url; later will be set by .env file
    private val apiKey = "{API_KEY}" //  the API Key, will be set by .env file later

    init {
        println(baseURL)
        println(apiKey)
        helloWorld()
    }

    private fun helloWorld() {

    }

    fun createEntry() {
        println("Hello")
    }
}
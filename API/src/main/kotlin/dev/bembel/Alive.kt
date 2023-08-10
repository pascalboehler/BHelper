package dev.bembel

import dev.bembel.utility.apiVersion
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureAlive() {
    routing {
        get ("$apiVersion/alive") {
            call.respondText("Hello world")
        }
    }
}


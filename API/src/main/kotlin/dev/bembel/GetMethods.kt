package dev.bembel

import dev.bembel.utility.apiVersion
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureGetMethods() {
    routing {
        get("$apiVersion/task") {
            call.respondText("{\"test\": \"it\"}", ContentType.Application.Json)
        }
    }
}
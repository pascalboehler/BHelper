package dev.bembel

import dev.bembel.utility.apiVersion
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureGetMethods() {
    routing {
        get("$apiVersion/task") {
            call.respondText("{\"endpoint\": \"Task\"}", ContentType.Application.Json)
        }

        get("$apiVersion/location") {
            call.respondText("{\"endpoint\": \"station\"}", ContentType.Application.Json)
        }

        get("$apiVersion/pic") {
            call.respondText("{\"endpoint\": \"pic\"}", ContentType.Application.Json)
        }

        get("$apiVersion/station") {
            call.respondText("{\"endpoint\": \"station\"}", ContentType.Application.Json)
        }

        get("$apiVersion/getInfo") {
            call.respondText("API DOC CAN BE FOUND IN GIT REPO")
        }
    }
}
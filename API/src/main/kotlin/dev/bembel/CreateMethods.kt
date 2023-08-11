package dev.bembel

import dev.bembel.utility.apiVersion
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureCreateMethods() {
    routing {
        post ("$apiVersion/create/task") {
            println("Created new task")
        }

        post ("$apiVersion/create/station") {

        }

        post ("$apiVersion/create/location") {

        }

        post ("$apiVersion/create/pic") {

        }
    }
}
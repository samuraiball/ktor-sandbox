package com.example.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {


    routing {
        get("/") {
                call.respondText("Hello World!")
            }
    }
}

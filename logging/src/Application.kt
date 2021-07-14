package dev.hirooka

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.application.environment.log.info("hello")
            throw RuntimeException("hello")
            //call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
    }
    install(CallLogging)
}


package com.example

import com.example.plugins.HelloService
import com.example.plugins.HelloServiceImpl
import com.example.plugins.UserName
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.dsl.module
import org.koin.ktor.ext.Koin


fun Application.main() {

    install(DefaultHeaders)
    install(CallLogging)

    routing {
        hello()
    }
}

fun Application.koin() {
    install(Koin) {
        modules(
            module {
                single { UserName() }
                single { HelloServiceImpl(get()) as HelloService }
            }
        )
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}

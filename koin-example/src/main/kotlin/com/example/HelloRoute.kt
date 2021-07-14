package com.example

import com.example.plugins.HelloService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.hello(){

    val helloService by inject<HelloService>()

    get("/koin"){
        call.respond("hello, ${helloService.greeting()}")
    }
}
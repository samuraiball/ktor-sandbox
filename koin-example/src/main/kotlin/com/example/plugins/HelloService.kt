package com.example.plugins

data class UserName(val value: String = "moheji")

interface HelloService {
    fun greeting(): String
}


class HelloServiceImpl(private val name: UserName) : HelloService {
    override fun greeting(): String {
        return "Hello, ${name.value}"
    }
}
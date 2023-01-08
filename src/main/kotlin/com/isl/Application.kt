package com.isl

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.isl.plugins.*
import com.isl.repository.DatabaseFactory
import io.ktor.server.locations.*

fun main() {
    embeddedServer(Netty, port = 8100, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Locations)
    DatabaseFactory.init()
    configureSerialization()
    configureMonitoring()
    configureRouting()

}

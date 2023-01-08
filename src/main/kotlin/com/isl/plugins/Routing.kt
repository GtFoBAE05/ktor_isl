package com.isl.plugins

import com.isl.repository.Repo
import com.isl.routes.SignRoutes
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        // Static plugin. Try to access `/static/index.html`
        static {
            resources("static")
        }

        SignRoutes(Repo())
    }
}

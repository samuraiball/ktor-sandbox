package hirooka.dev.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

    }
}

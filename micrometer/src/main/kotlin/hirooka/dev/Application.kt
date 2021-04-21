package hirooka.dev

import hirooka.dev.plugins.configureRouting
import io.ktor.application.*
import io.ktor.metrics.micrometer.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics
import io.micrometer.core.instrument.binder.system.ProcessorMetrics
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry

fun main() {
    val prometheusMeterRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(MicrometerMetrics) {
            registry = prometheusMeterRegistry
        }

        routing {
            get("/metrics") {
                call.respond(prometheusMeterRegistry.scrape())
            }
        }
        configureRouting()
    }.start(wait = true)
}

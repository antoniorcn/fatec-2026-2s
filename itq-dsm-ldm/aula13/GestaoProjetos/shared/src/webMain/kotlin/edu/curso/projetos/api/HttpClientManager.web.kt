package edu.curso.projetos.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.JsClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual fun httpClientManager() = HttpClient(JsClient()) {
    install(ContentNegotiation) {
        json(
            Json {
                coerceInputValues = true
                ignoreUnknownKeys = true
            }
        )
    }
    install(Logging) {
        level = LogLevel.ALL
    }
}
package edu.curso.projetos.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual fun httpClientManager() = HttpClient(Android) {
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
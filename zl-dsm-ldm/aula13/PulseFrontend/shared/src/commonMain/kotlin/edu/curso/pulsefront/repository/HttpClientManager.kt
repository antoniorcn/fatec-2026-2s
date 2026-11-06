package edu.curso.pulsefront.repository

import io.ktor.client.HttpClient

expect fun createHttpClient() : HttpClient

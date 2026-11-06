package edu.curso.pulsefront.repository

import edu.curso.pulsefront.model.Turma
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class TurmasRepository(private val httpClient: HttpClient) {
    private val endPoint = "http://localhost:8080/turmas"
    private val token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvQHRlc3RlLmNvbSIsInJvbGUiOlt7ImF1dGhvcml0eSI6IlVTRVIifV0sImlhdCI6MTc5Mzc5NzUwNSwiZXhwIjoxNzkzODAxMTA1fQ.mMA9iVPOCK8Cj-YjibP5UtArVJlGwqSUIlBC81hSXK0"

    suspend fun listar() : List<Turma> {
        return httpClient.get(endPoint){
            bearerAuth(token)
        }.body()
    }

    suspend fun salvar(turma : Turma) : Turma {
        val turmaSalva : Turma = httpClient.post(endPoint) {
            bearerAuth(token)
            contentType(ContentType.Application.Json)
            setBody(turma)
        }.body()
        return turmaSalva
    }

    suspend fun apagar(id : Long) {
        httpClient.delete("$endPoint/$id"){
            bearerAuth(token)
        }
    }

    suspend fun atualizar(turma : Turma) {
        httpClient.put("$endPoint/${turma.id}") {
            bearerAuth(token)
            contentType(ContentType.Application.Json)
            setBody(turma)
        }
    }
}
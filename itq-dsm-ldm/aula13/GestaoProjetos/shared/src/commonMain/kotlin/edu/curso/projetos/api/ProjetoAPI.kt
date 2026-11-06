package edu.curso.projetos.api

import edu.curso.projetos.model.Projeto
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

class ProjetoAPI( private val httpClient : HttpClient ) {

    private val endPoint = "http://192.168.68.103:8080/projetos"
    private val token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbnRvbmlvQHRlc3RlLmNvbSIsInJvbGVzIjpbIlVTRVIiXSwiZW1haWwiOiJhbnRvbmlvQHRlc3RlLmNvbSIsImlhdCI6MTc5Mzk5NzUwMSwiZXhwIjoxNzk0MDAxMTAxfQ.ALDyG42yLcbtVb6xsJFfhSE2LXssm5hi3E8sXXaZGetozXn4zz0ATPNALZeGVS4p"

    suspend fun salvar( prj : Projeto ) {
        httpClient.post(endPoint) {
            bearerAuth(token)
            contentType(ContentType.Application.Json)
            setBody( prj )
        }
    }

    suspend fun carregar() : List<Projeto> {
        val lista : List<Projeto> = httpClient.get(endPoint){
            bearerAuth(token)
        }.body()
        return lista
    }

    suspend fun apagar(prj : Projeto ) {
        httpClient.delete("$endPoint/${prj.id}") {
            bearerAuth(token)
        }
    }

    suspend fun atualizar(id : Long, prj : Projeto) {
        httpClient.put("$endPoint/$id") {
            bearerAuth(token)
            contentType(ContentType.Application.Json)
            setBody(prj)
        }
    }

}
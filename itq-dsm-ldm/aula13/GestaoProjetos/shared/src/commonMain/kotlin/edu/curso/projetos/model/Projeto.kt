package edu.curso.projetos.model

import kotlinx.serialization.Serializable

@Serializable
data class Projeto(
    val id: Int,
    val nome: String,
    val descricao: String,
    val dataInicio: String,
    val dataEntrega: String,
    val status: String
)
package edu.curso.projetos.model

data class Projeto(
    val id: Int,
    val nome: String,
    val descricao: String,
    val dataInicio: String,
    val dataFim: String,
    val status: String
) {
}
package edu.curso.projetos.dto

import java.time.LocalDate

data class ProjetoDTOResponse(
    val id : Long = 0,
    val nome: String = "",
    val descricao : String = "",
    val dataInicio : LocalDate = LocalDate.now(),
    val dataEntrega : LocalDate = LocalDate.now(),
    val status : String = ""
) {
}
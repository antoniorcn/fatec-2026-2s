package edu.curso.projetos.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class ProjetoDTORequest(
    @NotEmpty
    @Size(min=5, max=100)
    val nome: String = "",

    @NotEmpty(message="O campo descricao precisa ser preenchido")
    @Size(min=10, max=255, message="O conteudo da descrição precisa conter " +
            "no minimo 10 e no maximo 255 caracteres")
    val descricao : String = "",

    @Future
    val dataInicio : LocalDate = LocalDate.now(),

    @Future
    val dataEntrega : LocalDate = LocalDate.now(),

    @Size(min=5, max=30)
    val status : String = ""
) {
}
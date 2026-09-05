package edu.curso.projetos.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Projeto(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long? = null,
    val nome: String = "",
    val descricao : String = "",
    val dataInicio : LocalDate = LocalDate.now(),
    val dataEntrega : LocalDate = LocalDate.now(),
    val status : String = ""
) {
}
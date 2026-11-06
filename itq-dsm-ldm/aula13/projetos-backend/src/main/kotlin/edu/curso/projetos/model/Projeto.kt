package edu.curso.projetos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity
@Table(name = "projeto")
data class Projeto(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long? = null,

    @Column(name = "nome", length = 100,
        nullable = false, unique = true)
    @NotEmpty
    @Size(min=5, max=100)
    val nome: String = "",

    @Column(length=255, nullable = false)
    @NotEmpty(message="O campo descricao precisa ser preenchido")
    @Size(min=10, max=255, message="O conteudo da descrição precisa conter " +
            "no minimo 10 e no maximo 255 caracteres")
    val descricao : String = "",

    @Column(nullable = false)
    @Future
    val dataInicio : LocalDate = LocalDate.now(),

    @Column(nullable = false)
    @Future
    val dataEntrega : LocalDate = LocalDate.now(),

    @Column(nullable = false, length=30)
    @Size(min=5, max=30)
    val status : String = ""
) {
}
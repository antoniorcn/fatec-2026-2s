package edu.curso.projetos.model
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long,

    @Column(length = 50)
    val nome: String,

    @Column(length = 50)
    val email: String,
    val senha: String,
    val papeis : String
) {
    constructor() : this(0L, "", "",  "", "")
}

// val u = Usuario()
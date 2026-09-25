package edu.curso.pulse.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long,
    val nome : String,
    val email : String,
    val senha : String,
    val perfil : String  // ADMIN, USER, MANAGER
) {
    constructor() : this(0, "", "", "", "")
}


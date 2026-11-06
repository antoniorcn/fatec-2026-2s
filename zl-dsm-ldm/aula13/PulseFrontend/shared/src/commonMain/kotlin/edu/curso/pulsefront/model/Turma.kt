package edu.curso.pulsefront.model

import kotlinx.serialization.Serializable

@Serializable
data class Turma (
    val id : Long = 0,
    val codigo : String = "",
    val nomeDisciplina : String = "",
    val semestre : Int = 0,
    val ano : Int = 0
) {

}
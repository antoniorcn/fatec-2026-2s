package edu.curso.pulse.dto

// DTO - Data Transfer Object
data class TurmaViewDTO (
    val id : Long = 0,
    val codigo : String = "",
    val nomeDisciplina : String = "",
    val semestre : Int = 0,
    val ano : Int = 0
) {

}
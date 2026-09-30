package edu.curso.pulse.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length

// DTO - Data Transfer Object
data class TurmaDTO (
    @Length(min=3, max=10)
    @NotEmpty
    val codigo : String = "",
    @Length(min=5, max=30)
    val nomeDisciplina : String = "",
    @Min(1)
    @Max(2)
    val semestre : Int = 0,
    @Min(2026)
    val ano : Int = 0
) {

}
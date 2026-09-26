package edu.curso.projetos.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApplicationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException) : ResponseEntity<Map<String, String>> {
        val errors = HashMap<String, String>()
        ex.bindingResult.allErrors.forEach({ error ->
            if (error is FieldError) {
                val fieldName = error.field
                val errorMessage = error.defaultMessage ?: "Erro no campo $fieldName"
                errors[fieldName] = errorMessage
            }
        })
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }
}
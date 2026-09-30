package edu.curso.pulse.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApplicationExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodException( ex: MethodArgumentNotValidException) :
            ResponseEntity<Map<String, String>> {
        val erros = hashMapOf<String, String>()
        ex.bindingResult.allErrors.forEach( {
            erro ->
            if (erro is FieldError) {
                val fieldName = erro.field
                val message = erro.defaultMessage ?: "Erro no campo $fieldName"
                erros[fieldName] = message
            }
        } )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros)
    }
}
package edu.curso.hello.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import edu.curso.hello.model.Contato

@RestController
class ContatoController {
    
    val contatos = mutableListOf<Contato>(
        Contato(1, "Joao Silva", "1111", "joao@teste.com"),
        Contato(2, "Maria Silva", "2222", "maria@teste.com")
    )
    
    
    @GetMapping("/contato")
    fun listar() : List<Contato> {
        return contatos
    }
    
    @PostMapping("/contato")
    fun cadastrar(@RequestBody contato : Contato) : String { 
        contatos.add( contato )
        return "Contato cadastrado com sucesso"
    }
    
}
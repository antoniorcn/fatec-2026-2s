package edu.fatec.pageserver.controller

import edu.fatec.pageserver.model.Contato
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ContatoController {

    val contatos = mutableListOf<Contato>(
        Contato(1, "João Silva", "111111", "joao@teste.com"),
        Contato(2, "Maria Silva", "222222", "maria@teste.com"),
    )


    @GetMapping("/contato")
    fun listar() : List<Contato> {
        return contatos
    }

    @PostMapping("/contato")
    fun adicionar(@RequestBody contato : Contato) {
        contatos.add( contato )
    }

}
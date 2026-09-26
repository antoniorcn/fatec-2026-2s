package edu.curso.projetos.controller

import edu.curso.projetos.dto.ProjetoDTORequest
import edu.curso.projetos.dto.ProjetoDTOResponse
import edu.curso.projetos.mapper.ProjetoMapper
import edu.curso.projetos.model.Projeto
import edu.curso.projetos.service.ProjetoService
import jakarta.validation.Valid
import org.springframework.http.HttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/projetos")
class ProjetoController(
    private val service : ProjetoService,
    private val mapper : ProjetoMapper,
) {

    @GetMapping
    fun lerTodos() : List<ProjetoDTOResponse> {
        val projetos = service.lerTodos()
        return projetos.map{ mapper.toResponse( it ) }
    }

    @PostMapping
    fun cadastrar(@Valid @RequestBody projetoDto : ProjetoDTORequest) : ResponseEntity<String> {
        try {
            val projeto = mapper.toModel( projetoDto )
            service.cadastrar(projeto)
            return ResponseEntity.status(201).body("Projeto salvo com sucesso")
        } catch (_ : Exception) {
            return ResponseEntity.status(500).body("Erro ao salvar o projeto")
        }
    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable("id") id : Long) : ResponseEntity<String> {
        return try {
            if (service.apagar(id)) {
                ResponseEntity.status(200).body("Projeto removido com sucesso")
            } else {
                ResponseEntity.status(404).body("Projeto com id: $id não foi encontrado")
            }
        } catch (_ : Exception) {
            ResponseEntity.status(500).body("Erro ao remover o projeto")
        }
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id : Long,
                  @Valid @RequestBody projetoDto: ProjetoDTORequest) : ResponseEntity<String> {
        return try {
            val projeto = mapper.toModel( projetoDto )
            if(service.atualizar(id, projeto)) {
                ResponseEntity.status(200).body("Projeto atualizado com sucesso")
            } else {
                ResponseEntity.status(404).body("Projeto com id: $id não foi encontrado")
            }
        } catch (_ : Exception) {
            ResponseEntity.status(500).body("Erro ao atualizar o projeto")
        }
    }
}
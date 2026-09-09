package edu.curso.pulse.controller

import edu.curso.pulse.model.Turma
import edu.curso.pulse.repository.TurmaRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/turmas")
class TurmaController(
    val repository : TurmaRepository
) {

    @GetMapping
    fun getAll() : List<Turma> {
        return repository.findAll()
    }

    @PostMapping
    fun add(@RequestBody turma : Turma) : String {
        repository.save( turma )
        return "Turma gravada com sucesso"
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id : Long) : String {
        val optTurma = repository.findById(id)
        return if (optTurma.isPresent) {
            repository.delete(optTurma.get())
            "Turma excluída com sucesso"
        } else {
            "Turma não encontrada"
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id : Long,
               @RequestBody turma : Turma) : String {
        val optTurma = repository.findById(id)
        return if (optTurma.isPresent) {
            val turmaNova = turma.copy( id = id )
            repository.save(turmaNova)
            "Turma atualizada com sucesso"
        } else {
            "Turma não encontrada"
        }
    }
}
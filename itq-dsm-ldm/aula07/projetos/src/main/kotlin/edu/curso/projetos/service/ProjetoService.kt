package edu.curso.projetos.service

import edu.curso.projetos.dto.ProjetoDTORequest
import edu.curso.projetos.model.Projeto
import edu.curso.projetos.repository.ProjetoRepository
import org.springframework.stereotype.Service

@Service
class ProjetoService(
    val repository : ProjetoRepository
) {

    fun lerTodos() : List<Projeto>{
        return repository.findAll()
    }

    fun cadastrar(projeto : Projeto) {
        repository.save(projeto)
    }

    fun apagar(id : Long) : Boolean {
        val optProjeto = repository.findById(id)
        return if (optProjeto.isPresent) {
            repository.delete(optProjeto.get() )
            true
        } else { false }
    }

    fun atualizar(id : Long, projeto: Projeto ) : Boolean {
        val optProjeto = repository.findById(id)
        return if (optProjeto.isPresent) {
            val projetoAtualizado = projeto.copy(id = id)
            repository.save(projetoAtualizado)
            true
        } else { false }
    }
}
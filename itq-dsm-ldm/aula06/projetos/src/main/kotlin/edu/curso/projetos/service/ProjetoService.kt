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

    fun cadastrar(projetoDto : ProjetoDTORequest) {
        val projeto = Projeto(
            id = null,
            nome = projetoDto.nome,
            descricao = projetoDto.descricao,
            dataInicio = projetoDto.dataInicio,
            dataEntrega = projetoDto.dataEntrega,
            status = projetoDto.status
        )
        repository.save(projeto)
    }

    fun apagar(id : Long) : Boolean {
        val optProjeto = repository.findById(id)
        return if (optProjeto.isPresent) {
            repository.delete(optProjeto.get() )
            true
        } else { false }
    }

    fun atualizar(id : Long, projetoDto: ProjetoDTORequest ) : Boolean {
        val optProjeto = repository.findById(id)
        return if (optProjeto.isPresent) {
            val projeto = Projeto(
                id = null,
                nome = projetoDto.nome,
                descricao = projetoDto.descricao,
                dataInicio = projetoDto.dataInicio,
                dataEntrega = projetoDto.dataEntrega,
                status = projetoDto.status
            )
            val projetoAtualizado = projeto.copy(id = id)
            repository.save(projetoAtualizado)
            true
        } else { false }
    }
}
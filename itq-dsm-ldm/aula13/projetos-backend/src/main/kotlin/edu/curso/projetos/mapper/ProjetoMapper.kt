package edu.curso.projetos.mapper

import edu.curso.projetos.dto.ProjetoDTORequest
import edu.curso.projetos.dto.ProjetoDTOResponse
import edu.curso.projetos.model.Projeto
import org.springframework.stereotype.Component

@Component
class ProjetoMapper {

    fun toModel( projetoDto : ProjetoDTORequest ) : Projeto {
        return Projeto(
            id = null,
            nome = projetoDto.nome,
            descricao = projetoDto.descricao,
            dataInicio = projetoDto.dataInicio,
            dataEntrega = projetoDto.dataEntrega,
            status = projetoDto.status
        )
    }

    fun toResponse( projeto : Projeto ) : ProjetoDTOResponse {
        return ProjetoDTOResponse(id=projeto.id ?: 0, nome=projeto.nome,
            descricao=projeto.descricao, dataInicio=projeto.dataInicio,
            dataEntrega=projeto.dataEntrega, status=projeto.status)
    }

}
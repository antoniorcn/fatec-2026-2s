package edu.curso.pulse.mapper

import edu.curso.pulse.dto.TurmaDTO
import edu.curso.pulse.dto.TurmaViewDTO
import edu.curso.pulse.model.Turma
import org.springframework.stereotype.Component

@Component
class TurmaMapper {

    fun toModel( turmaDTO : TurmaDTO ) : Turma {
        val turma = Turma(  id = 0, codigo = turmaDTO.codigo,
            nomeDisciplina = turmaDTO.nomeDisciplina,
            semestre = turmaDTO.semestre,
            ano=turmaDTO.ano
        )
        return turma
    }

    fun toDTO( turma : Turma ) : TurmaViewDTO {
        val turmaGravadaViewDTO = TurmaViewDTO(id = turma.id,
            nomeDisciplina = turma.nomeDisciplina, codigo = turma.codigo,
            semestre = turma.semestre, ano=turma.ano)
        return turmaGravadaViewDTO
    }

}
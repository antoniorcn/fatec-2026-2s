package edu.curso.pulse.controller

import edu.curso.pulse.dto.TurmaDTO
import edu.curso.pulse.dto.TurmaViewDTO
import edu.curso.pulse.model.Turma
import edu.curso.pulse.service.TurmaService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
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
    private val service : TurmaService
) {

    @GetMapping
    fun getAll() : ResponseEntity<List<TurmaViewDTO>> {
        return try {
            val listaTurma = service.getAll()
            val listaTurmaViewDTO = listaTurma.map({ turma ->
                TurmaViewDTO(id = turma.id, nomeDisciplina = turma.nomeDisciplina,
                semestre = turma.semestre, ano=turma.ano, codigo = turma.codigo)
            })
            ResponseEntity.ok(listaTurmaViewDTO)
        } catch (ex: Exception) {
            ResponseEntity.status(500).body(emptyList())
        }
    }

    @PostMapping
    fun add(@Valid @RequestBody turmaDTO : TurmaDTO) : ResponseEntity<TurmaViewDTO> {
        return try {
            val turma = Turma(  id = 0, codigo = turmaDTO.codigo,
                                nomeDisciplina = turmaDTO.nomeDisciplina,
                                semestre = turmaDTO.semestre,
                                ano=turmaDTO.ano
                )
            val turmaGravada = service.add(turma)
            val turmaGravadaViewDTO = TurmaViewDTO(id = turmaGravada.id,
                nomeDisciplina = turmaGravada.nomeDisciplina, codigo = turmaGravada.codigo,
                semestre = turmaGravada.semestre, ano=turmaGravada.ano)
            ResponseEntity.ok(turmaGravadaViewDTO )
        } catch (ex : Exception) {
            ResponseEntity.internalServerError().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id : Long) : ResponseEntity<String> {
        return try {
            if (service.delete(id)) {
                ResponseEntity.ok("Turma excluída com sucesso")
            } else {
                ResponseEntity.status(404).body("Turma não encontrada forneça o /id corretamente na url")
            }
        } catch (ex: Exception) {
            ResponseEntity.status(500).body("Ocorreu um erro ao tentar excluir a turma")
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id : Long,
               @Valid @RequestBody turmaDTO : TurmaDTO) : ResponseEntity<String> {
        return try {
            val turma = Turma(  id = 0, codigo = turmaDTO.codigo,
                nomeDisciplina = turmaDTO.nomeDisciplina,
                semestre = turmaDTO.semestre,
                ano=turmaDTO.ano
            )
            if (service.update(id, turma)) {
                ResponseEntity.ok("Turma atualizada com sucesso")
            } else {
                ResponseEntity.status(404).body("Turma não encontrada forneça o /id corretamente na url")
            }
        } catch (ex: Exception) {
            ResponseEntity.status(500).body("Ocorreu um erro ao tentar atualizar a turma")
        }
    }
}
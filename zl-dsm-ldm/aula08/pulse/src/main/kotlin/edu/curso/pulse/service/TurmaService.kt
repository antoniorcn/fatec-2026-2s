package edu.curso.pulse.service

import edu.curso.pulse.model.Turma
import edu.curso.pulse.repository.TurmaRepository
import org.springframework.stereotype.Service

@Service
class TurmaService(
    private val repository: TurmaRepository
) {

    fun getAll() : List<Turma> {
        return repository.findAll()
    }

    fun add(turma : Turma) : Turma {
        return repository.save( turma )
    }

    fun delete(id : Long) : Boolean {
        val optTurma = repository.findById(id)
        return if (optTurma.isPresent) {
            repository.delete(optTurma.get())
            true
        } else {
            false
        }
    }

    fun update(id : Long, turma : Turma) : Boolean {
        val optTurma = repository.findById(id)
        return if (optTurma.isPresent) {
            val turmaNova = turma.copy( id = id )
            repository.save(turmaNova)
            true
        } else {
            false
        }
    }
}
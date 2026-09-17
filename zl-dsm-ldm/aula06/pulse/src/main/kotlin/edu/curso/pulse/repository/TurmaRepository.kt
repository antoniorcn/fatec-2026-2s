package edu.curso.pulse.repository

import edu.curso.pulse.model.Turma
import org.springframework.data.jpa.repository.JpaRepository

interface TurmaRepository : JpaRepository<Turma, Long> {
}
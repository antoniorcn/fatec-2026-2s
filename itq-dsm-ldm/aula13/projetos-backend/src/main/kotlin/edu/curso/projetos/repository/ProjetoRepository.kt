package edu.curso.projetos.repository

import edu.curso.projetos.model.Projeto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface ProjetoRepository : JpaRepository<Projeto, Long> {
}
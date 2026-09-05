package edu.curso.projetos.repository

import edu.curso.projetos.model.Projeto
import org.springframework.data.jpa.repository.JpaRepository

interface ProjetoRepository : JpaRepository<Projeto, Long> {
}
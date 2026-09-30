package edu.curso.pulse.repository

import edu.curso.pulse.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UsuarioRepository : JpaRepository<Usuario, Long> {
    fun findByEmail(email : String) : Usuario?

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    fun procurarPorEmail(@Param("email") email : String) : Usuario?
}
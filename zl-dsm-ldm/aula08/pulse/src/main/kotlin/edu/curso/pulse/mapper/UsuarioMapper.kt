package edu.curso.pulse.mapper

import edu.curso.pulse.dto.UsuarioRequestDTO
import edu.curso.pulse.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioMapper {

    fun toModel( dto : UsuarioRequestDTO) : Usuario {
        return Usuario(
            id = 0,
            nome = dto.nome,
            email = dto.email,
            senha = dto.senha,
            perfil = "USER"
        )
    }
}
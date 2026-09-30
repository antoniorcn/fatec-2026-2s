package edu.curso.pulse.controller

import edu.curso.pulse.dto.CredenciaisDTO
import edu.curso.pulse.dto.UsuarioRequestDTO
import edu.curso.pulse.mapper.UsuarioMapper
import edu.curso.pulse.repository.UsuarioRepository
import edu.curso.pulse.security.jwtUtils
import edu.curso.pulse.service.UserDetailsServiceImplementation
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val mapper : UsuarioMapper,
    private val repository : UsuarioRepository,
    private val passwordEncoder : PasswordEncoder,
    private val service : UserDetailsServiceImplementation,
    private val jwtUtils : jwtUtils
) {

    @PostMapping("/signup")
    fun signup(
        @RequestBody usuarioDTO : UsuarioRequestDTO
    ) : ResponseEntity<String> {
        return try {
            val senhaCodificada = passwordEncoder.encode(usuarioDTO.senha)
            if (senhaCodificada != null) {
                val usuario = mapper.toModel(usuarioDTO).copy(senha = senhaCodificada)
                repository.save(usuario)
                ResponseEntity.ok("Usuario ${usuario.nome} criado com sucesso")
            } else {
                ResponseEntity.internalServerError()
                    .body("Ocorreu um erro ao tentar criar o usuário - senha invalida")
            }
        } catch (ex : Exception) {
            ResponseEntity.internalServerError()
                .body("Ocorreu um erro ao tentar criar o usuário")
        }
    }

    @PostMapping("/signin")
    fun signin(
        @RequestBody credenciais : CredenciaisDTO
    ) : ResponseEntity<String> {
        return try {
            val userDetail = service.loadUserByUsername(credenciais.email)
            if (passwordEncoder.matches(
                    credenciais.senha,
                    userDetail.password
                )
            ) {
                val token = jwtUtils.generateToken(userDetail.username, mapOf(
                    "role" to userDetail.authorities
                ))
                ResponseEntity.ok(token )
            } else {
                ResponseEntity.status(401).body("Credenciais inválidas")
            }
        } catch (ex : Exception) {
            ResponseEntity.status(401).body("Erro ao fazer o login")
        }

    }
}
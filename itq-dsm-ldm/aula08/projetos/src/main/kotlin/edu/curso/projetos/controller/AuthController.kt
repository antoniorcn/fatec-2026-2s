package edu.curso.projetos.controller

import edu.curso.projetos.dto.CredenciaisDTO
import edu.curso.projetos.dto.UsuarioDTO
import edu.curso.projetos.model.Usuario
import edu.curso.projetos.security.JwtUtils
import edu.curso.projetos.security.UsuarioService
import io.jsonwebtoken.Jwt
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
    
@RestController
@RequestMapping("/auth")
class AuthController(
    private val service : UsuarioService,
    private val jwt : JwtUtils
) {
    
    
    @PostMapping("/signin")
    fun signIn(@RequestBody credenciaisDTO : CredenciaisDTO) : ResponseEntity<String>{
        println("/SignIn acionado")
        val ud = service.loadUserByUsername(credenciaisDTO.email)
        val claims = mapOf("roles" to ud.authorities.map { it.authority }, "email" to ud.username)
        val token = jwt.generateToken(ud.username, claims)
        println("Token gerado: $token")
        return ResponseEntity.ok(token)
    }
    
    @PostMapping("/signup")
    fun signUp(@RequestBody usuarioDTO : UsuarioDTO) : ResponseEntity<String>{
        println("/SignUp acionado")
        val usuario = Usuario(
            id = 0,
            nome = usuarioDTO.nome,
            email = usuarioDTO.email,
            senha = usuarioDTO.senha,
            papeis = "USER"
        )
        return if (service.cadastrar( usuario )) {
            ResponseEntity.ok("Usuário cadastrado com sucesso")
        } else {
            ResponseEntity.badRequest().body("Falha ao cadastrar usuário")
        }
    }
}
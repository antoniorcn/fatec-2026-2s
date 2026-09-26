package edu.curso.projetos.security

import edu.curso.projetos.model.Usuario
import edu.curso.projetos.repository.UsuarioRepository
import org.springframework.context.annotation.Bean
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val repository : UsuarioRepository,
//    private val jwtUtil: JwtUtils
) : UserDetailsService {

//    fun doFilterInternal( request: HttpServletRequest,
//                          response: HttpServletResponse,
//                          filterChain: FilterChain,
//    ) {
//        val header = request.getHeader("Authorization")
//        if (header != null && header.startsWith("Bearer ")) {
//            val token = header.substring(7)
//            if (jwtUtil.validateToken(token)) {
//                val username = jwtUtil.getUsernameFromToken(token)
//                val userDetails = loadUserByUsername(username)
//                val authentication = UsernamePasswordAuthenticationToken(
//                    userDetails, null, userDetails.authorities
//                )
//                authentication.details = WebAuthenticationDetailsSource()
//                    .buildDetails(request)
//                SecurityContextHolder.getContext().authentication = authentication
//            }
//        }
//        filterChain.doFilter(request, response)
//    }

    fun getPasswordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun loadUserByUsername(username: String): UserDetails {
        println("UsuarioService sendo executado: Username $username")
        val usuario = repository.findByUserName( username )
        if ( usuario != null ){
            println("Usuario existe: $usuario")
            val senhaCodificada = getPasswordEncoder().encode(usuario.senha )
            println("Senha codificada: $senhaCodificada")
            return UserDetailImplementation(usuario)
        } else {
            throw UsernameNotFoundException("User not found with username: $username")
        }
    }

    fun cadastrar(usuario : Usuario) : Boolean {
        val senhaCodificada = getPasswordEncoder().encode(usuario.senha )
        return if (senhaCodificada != null) {
            val usuarioCodificado = usuario.copy(senha = senhaCodificada)
            repository.save(usuarioCodificado)
            true
        } else {
            false
        }

    }
}
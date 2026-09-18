package edu.curso.projetos.security

import edu.curso.projetos.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val repository : UsuarioRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        println("UsuarioService sendo executado: Username $username")
        val usuario = repository.findByUserName( username )
        if ( usuario != null ){
            print("Usuario existe: $usuario")
            return UserDetailImplementation(usuario)
        } else {
            throw UsernameNotFoundException("User not found with username: $username")
        }
    }
}
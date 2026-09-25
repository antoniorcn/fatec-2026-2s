package edu.curso.pulse.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import edu.curso.pulse.repository.UsuarioRepository
import edu.curso.pulse.security.UserDetailImplementation
import org.springframework.stereotype.Service
import org.springframework.security.crypto.password.PasswordEncoder

@Service
class UserDetailsServiceImplementation (
    private val repository : UsuarioRepository,
    private val passwordEncoder : PasswordEncoder
) : UserDetailsService {
    override fun loadUserByUsername( email: String ) : UserDetails {
        println("Procurando usuario: $email no repository")
        val user = repository.procurarPorEmail( email )
        if ( user != null ) {
            println("Usuario $email encontrado: $user")
            val senhaEncoded = passwordEncoder.encode( user.senha );
            println("Senha encoded: $senhaEncoded")
            val userDetail = UserDetailImplementation(user)
            println("UsuarioDetail: $userDetail")
            return userDetail
        }
        throw UsernameNotFoundException("Erro ao autenticar o email: $email")
    }

}
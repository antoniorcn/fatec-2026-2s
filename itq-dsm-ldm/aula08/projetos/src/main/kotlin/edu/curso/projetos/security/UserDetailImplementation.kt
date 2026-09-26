package edu.curso.projetos.security

import edu.curso.projetos.model.Usuario
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority

class UserDetailImplementation(
    val usuario : Usuario
) : UserDetails {

    override fun getPassword() : String {
        return usuario.senha
    }

    override fun getUsername(): String {
        return usuario.email
    }

    override fun getAuthorities() : Collection<GrantedAuthority> {
        val papeis = usuario.papeis.split(",") // "ADMIN,USER"
        val lista = papeis.map { papel -> GrantedAuthority { papel } }
        return lista
    }

    override fun isEnabled(): Boolean { return true }
    override fun isCredentialsNonExpired(): Boolean { return true }
    override fun isAccountNonExpired(): Boolean { return true }
    override fun isAccountNonLocked(): Boolean { return true }
}


// val user = Usuario(1L, "Joao Silva",
//     "joao@teste.com", "123456", "ADMIN")
//
// val u = UserDetailImplementation(user)
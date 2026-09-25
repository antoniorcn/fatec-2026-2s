package edu.curso.pulse.security
import edu.curso.pulse.model.Usuario
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

class UserDetailImplementation(
    private val usuario: Usuario,
) : UserDetails {
    override fun getUsername(): String = usuario.email
    override fun getPassword(): String = usuario.senha
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = true
    override fun getAuthorities() : Collection<GrantedAuthority> {
        val grantedAuthorities = mutableListOf<GrantedAuthority>()
        val perfis = usuario.perfil.split(",")  // "ADMIN, USER, MANAGER"
        for (perfil in perfis) {
            grantedAuthorities.add(SimpleGrantedAuthority( perfil.trim() ))
        }
        return grantedAuthorities
    }
}

//val u = Usuario(1, "Joao", "joao@teste.com", "123456", "ADMIN")
//
//val ud = UserDetailImplementation( u )


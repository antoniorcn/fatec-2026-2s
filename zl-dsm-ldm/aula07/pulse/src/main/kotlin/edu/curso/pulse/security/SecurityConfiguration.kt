package edu.curso.pulse.security
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder



@Configuration
@EnableMethodSecurity
class SecurityConfiguration {
    @Bean
    fun getPasswordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}

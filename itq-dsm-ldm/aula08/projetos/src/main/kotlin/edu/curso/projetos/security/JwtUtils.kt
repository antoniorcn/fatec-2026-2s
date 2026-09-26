package edu.curso.projetos.security
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtils {
    private val SECRET_KEY = Keys.hmacShaKeyFor(
            "IstoEumaChavesecretadoAntonioNaAulaDeSpringBoot2026".toByteArray()
    )

    private val expirationTime = 60 * 60 * 1000 // 1 hour
    fun generateToken(username: String, claims : Map<String, Any>): String {
        return Jwts.builder()
            .subject(username)
            .claims(claims)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(SECRET_KEY).compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
            true
        } catch (e: Exception) { false }
    }

    fun getUsernameFromToken(token: String): String {
        return Jwts.parser()
            .verifyWith(SECRET_KEY)
            .build()
            .parseSignedClaims(token).payload.subject
    }





}
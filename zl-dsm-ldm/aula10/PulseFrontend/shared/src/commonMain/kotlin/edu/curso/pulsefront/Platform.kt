package edu.curso.pulsefront

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
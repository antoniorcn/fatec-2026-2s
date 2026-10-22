package edu.curso.projetos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package edu.curso.hello

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package edu.curso.olakmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
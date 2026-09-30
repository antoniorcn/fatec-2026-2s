package edu.curso.pulse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PulseApplication

fun main(args: Array<String>) {
	runApplication<PulseApplication>(*args)
}

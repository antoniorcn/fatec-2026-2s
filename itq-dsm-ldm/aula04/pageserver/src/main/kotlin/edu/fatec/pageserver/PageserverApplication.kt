package edu.fatec.pageserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PageserverApplication

fun main(args: Array<String>) {
	runApplication<PageserverApplication>(*args)
}

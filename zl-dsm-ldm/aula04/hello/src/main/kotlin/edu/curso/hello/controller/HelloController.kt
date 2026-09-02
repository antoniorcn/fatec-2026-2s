package edu.curso.hello.controller
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController { 
    
    @GetMapping("/ola")
    fun hello() : String { 
        return "ola"
    }
    
    
}
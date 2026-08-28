package edu.fatec.pageserver.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {

    @GetMapping("/ola")
    fun ola() : String {
        return "OlaView"
    }

}
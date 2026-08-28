package edu.fatec.pageserver.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PrincipalController {

    @GetMapping("/")
    fun principal() : String {
        return "PrincipalView"
    }
}
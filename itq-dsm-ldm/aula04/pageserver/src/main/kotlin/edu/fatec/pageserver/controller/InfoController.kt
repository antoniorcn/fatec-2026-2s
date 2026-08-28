package edu.fatec.pageserver.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
@Controller
class InfoController {

    @GetMapping("/info")
    fun info() : String {
        return "InfoView"
    }
}
package edu.fatec.pageserver.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDateTime

@Controller
class DataHoraController {

    @GetMapping("/clock")
    fun info() : ModelAndView {

        val modelView = ModelAndView("DataHora")
        val current = LocalDateTime.now()
        modelView.addObject("dataHora", current)
        return modelView
    }
}
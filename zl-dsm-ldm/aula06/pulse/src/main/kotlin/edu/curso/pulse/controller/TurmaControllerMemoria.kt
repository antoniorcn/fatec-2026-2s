//package edu.curso.pulse.controller
//
//import edu.curso.pulse.model.Turma
//import org.springframework.web.bind.annotation.DeleteMapping
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.PutMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//class TurmaControllerOld {
//    val turmas = mutableListOf<Turma>()
//
//    @GetMapping("/turmas")
//    fun getAll() : List<Turma> {
//        return turmas
//    }
//
//    @PostMapping("/turmas")
//    fun add(@RequestBody turma: Turma) : String {
//        turmas.add(turma)
//        return "Turma adicionada com sucesso"
//    }
//
////    @DeleteMapping("/turmas")
////    fun delete(@RequestParam id : Long) : String {
//    @DeleteMapping("/turmas/{id}")
//    fun delete(@PathVariable id : Long) : String {
////        for (i in turmas.indices) {
////            if (turmas[i].id == id) {
////                turmas.removeAt(i)
////                return "Turma apagada com sucesso"
////            }
////        }
////        return "Turma não encontrada"
//        val sizeAntigo = turmas.size
//        turmas.removeIf { it.id == id }
//        return if (sizeAntigo == turmas.size) "Turma não encontrada" else "Turma apagada com sucesso"
//    }
//
//    @PutMapping("/turmas/{id}")
//    fun update(@PathVariable id : Long,
//               @RequestBody turma: Turma) : String {
//        for (i in turmas.indices) {
//            if (turmas[i].id == id) {
//                turmas[i] = turma
//                return "Turma atualizada com sucesso"
//            }
//        }
//        return "Turma não encontrada"
//    }
//}
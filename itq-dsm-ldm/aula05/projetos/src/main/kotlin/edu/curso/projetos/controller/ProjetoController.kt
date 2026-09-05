package edu.curso.projetos.controller

import edu.curso.projetos.model.Projeto
import edu.curso.projetos.repository.ProjetoRepository
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/projetos")
class ProjetoController(
    val repository : ProjetoRepository
) {

    val projetos = mutableListOf<Projeto>(
        Projeto(    id=1, nome = "Novo Siga", dataEntrega = LocalDate.of(2027, 5, 30),
                    descricao = "Sistema de acesso ao Siga totalmente novo", status = "Em andamento"),
        Projeto(    id=2, nome = "Quioske", dataEntrega = LocalDate.of(2026, 11, 30),
            descricao = "Quioske de Autoatendimento para a Lanchonete", status = "Em andamento"),
    )

    var contadorId : Long = projetos.size.toLong() + 1

    @GetMapping
    fun lerTodos() : List<Projeto> {
        return repository.findAll()
        // return projetos
    }

    /*

        {   "id" : null,
            "nome" : "Novo Siga",
            "descricao" : "Sistema de acesso ao Siga totalmente novo",
            "dataInicio" : "2024-06-01",
            "dataEntrega" : "2024-12-31",
            "status" : "Em andamento"
        }

     */

    @PostMapping
    fun cadastrar(@RequestBody projeto : Projeto) {
        /*
            {   "id" : null,
                "nome" : "Novo Siga",
                "descricao" : "Sistema de acesso ao Siga totalmente novo",
                "dataInicio" : "2024-06-01",
                "dataEntrega" : "2024-12-31",
                "status" : "Em andamento"
            }
        */
        // val novaInstancia = projeto.copy(id=contadorId)
        /*
            {   "id" : 3,
                "nome" : "Novo Siga",
                "descricao" : "Sistema de acesso ao Siga totalmente novo",
                "dataInicio" : "2024-06-01",
                "dataEntrega" : "2024-12-31",
                "status" : "Em andamento"
            }
        */
        // val projetoNovo = projeto.copy(id = contadorId++)
        // projetos.add(projetoNovo)
        repository.save(projeto)
    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable("id") id : Long) {
//        val projetosNovos = mutableListOf<Projeto>()
//        for ( prj in projetos) {
//            if (prj.id != id) {
//                projetosNovos.add(prj)
//            }
//        }
//        projetos.clear()
//        projetos.addAll(projetosNovos)
        // projetos.removeIf( { prj -> prj.id == id } )
        // projetos.removeIf { prj -> prj.id == id }
        // val projeto = projetos.find { it.id == id }
        // projetos.removeIf { it.id == id }
        repository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id : Long,
                  @RequestBody projeto : Projeto) {
        val projetoAtualizado = projeto.copy(id = id)
//        for (i in 0..projetos.size) {
//            if (projetos[i].id == id) {
//                projetos[i] = projetoAtualizado
//                break
//            }
//        }
        repository.save(projetoAtualizado)
    }
}
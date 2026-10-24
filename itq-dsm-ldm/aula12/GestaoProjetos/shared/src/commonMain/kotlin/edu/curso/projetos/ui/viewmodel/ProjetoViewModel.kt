package edu.curso.projetos.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.curso.projetos.model.Projeto
import kotlinx.coroutines.flow.*

class ProjetoViewModel : ViewModel() {

//    val projetos = mutableListOf<Projeto>(
//        Projeto(1, "Entrega de Trabalho", "Entrega do trabalho Interdisciplinar", "2026-10-09", "2026-10-16", "Concluido"),
//        Projeto(2, "Preparacao para Aula", "Preparativos para aula de LDM", "2026-10-01", "2026-10-30", "Em andamento"),
//    )
    private var idCounter : Int = 0
    private val _projetos = MutableStateFlow<List<Projeto>>(listOf(
        Projeto(1, "Entrega de Trabalho", "Entrega do trabalho Interdisciplinar", "2026-10-09", "2026-10-16", "Concluido"),
        Projeto(2, "Preparacao para Aula", "Preparativos para aula de LDM", "2026-10-01", "2026-10-30", "Em andamento"),
    ))
    private val _filtro = MutableStateFlow("")
    val filtro = _filtro.asStateFlow()

    fun atualizarFiltro(novoFiltro: String) {
        _filtro.value = novoFiltro
    }

    val projetosFiltrados = combine(_projetos, _filtro) {
        projetos, filtro ->
            if (filtro.isEmpty()) {
                projetos
            } else {
                projetos.filter { it.nome.contains(filtro, ignoreCase = true) }
            }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    val tela = mutableStateOf("list")

    val id =  mutableStateOf("")
    val nome =  mutableStateOf("")
    val descricao =  mutableStateOf("")
    val dataInicio =  mutableStateOf("")
    val dataFim =  mutableStateOf("")
    val status =  mutableStateOf("")

    fun salvar() {
        val projeto =  Projeto(
            0, nome=nome.value,
            descricao=descricao.value,
            dataInicio=dataInicio.value,
            dataFim=dataFim.value,
            status=status.value
        )

        if (id.value == "") {
            idCounter++
            _projetos.update{ lista -> lista + projeto.copy(id = idCounter) }
        } else {
            val idNumber = id.value.toInt()
            // val nossaLista = listOf(1, 3, 5 ,7)
            // val outraLista = nossaLista.map { numero -> numero * numero }
            // lista
            _projetos.update{ lista ->
                lista.map { prj -> if( prj.id == idNumber ) projeto.copy(id = idNumber ) else  prj  }
            }
        }
        tela.value = "list"

    }

    fun apagar(projeto : Projeto) {
        _projetos.update{ lista -> lista - projeto }
    }

    fun novoProjeto() {
        tela.value = "form"
        id.value = ""
        nome.value = ""
        descricao.value = ""
        dataInicio.value = ""
        dataFim.value = ""
        status.value = ""
    }

    fun editar(projeto : Projeto) {
        tela.value = "form"
        id.value = projeto.id.toString()
        nome.value=projeto.nome
        descricao.value=projeto.descricao
        dataInicio.value=projeto.dataInicio
        dataFim.value=projeto.dataFim
        status.value=projeto.status
    }

    fun pesquisar() {
        for (prj in _projetos.value) {
            if (prj.nome.contains( nome.value )) {
                nome.value = prj.nome
                descricao.value = prj.descricao
                dataInicio.value = prj.dataInicio
                dataFim.value = prj.dataFim
                status.value = prj.status
            }
        }
    }
}
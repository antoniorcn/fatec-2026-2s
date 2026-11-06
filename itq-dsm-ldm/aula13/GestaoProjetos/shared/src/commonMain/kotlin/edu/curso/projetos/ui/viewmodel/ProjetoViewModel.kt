package edu.curso.projetos.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.curso.projetos.api.ProjetoAPI
import edu.curso.projetos.api.httpClientManager
import edu.curso.projetos.model.Projeto
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProjetoViewModel : ViewModel() {
    val httpClient = httpClientManager()
    val projetoApi = ProjetoAPI(httpClient)

    private var idCounter : Int = 0
    private val _projetos = MutableStateFlow<List<Projeto>>(listOf(
        // Projeto(1, "Entrega de Trabalho", "Entrega do trabalho Interdisciplinar", "2026-10-09", "2026-10-16", "Concluido"),
        // Projeto(2, "Preparacao para Aula", "Preparativos para aula de LDM", "2026-10-01", "2026-10-30", "Em andamento"),
    ))
    private val _filtro = MutableStateFlow("")
    val filtro = _filtro.asStateFlow()

    init {
        viewModelScope.launch {
            _projetos.value = projetoApi.carregar()
        }
    }

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
    val dataEntrega =  mutableStateOf("")
    val status =  mutableStateOf("")

    fun salvar() {
        val projeto =  Projeto(
            0, nome=nome.value,
            descricao=descricao.value,
            dataInicio=dataInicio.value,
            dataEntrega=dataEntrega.value,
            status=status.value
        )

        if (id.value == "") {
            // idCounter++
            // _projetos.update{ lista -> lista + projeto.copy(id = idCounter) }
            viewModelScope.launch {
                projetoApi.salvar(projeto)
                projetoApi.carregar().let {
                    _projetos.value = it
                }
            }
        } else {
            val idNumber = id.value.toLong()
            viewModelScope.launch {
                projetoApi.atualizar(idNumber, projeto)
                projetoApi.carregar().let {
                    _projetos.value = it
                }
            }
//            val idNumber = id.value.toInt()
//            _projetos.update{ lista ->
//                lista.map { prj -> if( prj.id == idNumber ) projeto.copy(id = idNumber ) else  prj  }
//            }
        }
        tela.value = "list"

    }

    fun apagar(projeto : Projeto) {
        // _projetos.update{ lista -> lista - projeto }
        println("Isto sera executado primeiro")
        viewModelScope.launch {
            println("Isto sera executado primeiro na corroutine")
            projetoApi.apagar( projeto )
            projetoApi.carregar().let {
                _projetos.value = it
            }
            println("Isto sera executado quando o processo de apagar for concluido")
        }
        println("Isto sera executado primeiro")

        // executarThreadA()
        // executarThreadB()
    }

    fun novoProjeto() {
        tela.value = "form"
        id.value = ""
        nome.value = ""
        descricao.value = ""
        dataInicio.value = ""
        dataEntrega.value = ""
        status.value = ""
    }

    fun editar(projeto : Projeto) {
        tela.value = "form"
        id.value = projeto.id.toString()
        nome.value=projeto.nome
        descricao.value=projeto.descricao
        dataInicio.value=projeto.dataInicio
        dataEntrega.value=projeto.dataEntrega
        status.value=projeto.status
    }

    fun pesquisar() {
        for (prj in _projetos.value) {
            if (prj.nome.contains( nome.value )) {
                nome.value = prj.nome
                descricao.value = prj.descricao
                dataInicio.value = prj.dataInicio
                dataEntrega.value = prj.dataEntrega
                status.value = prj.status
            }
        }
    }
}
package edu.curso.pulsefront.viewmodel

import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavBackStack
import edu.curso.pulsefront.model.Turma
import edu.curso.pulsefront.ui.navigation.TurmaRotas
import kotlinx.coroutines.flow.*

class TurmaViewModel(
    private val mandarMensagem : ( String, SnackbarDuration) -> Unit
) : ViewModel() {

    private val _lista : MutableStateFlow<List<Turma>> = MutableStateFlow(listOf(
        Turma(
            id = 1,
            codigo = "DSA",
            nomeDisciplina = "Desenvolvimento de Sistemas para Aplicações",
            semestre = 2,
            ano = 2026
        ),
        Turma(
            id = 2,
            codigo = "LDM",
            nomeDisciplina = "Linguagem de Modelagem",
            semestre = 2,
            ano = 2026
        ),
    ))
    private var _filtro : MutableStateFlow<String> = MutableStateFlow("")
    val filtro = _filtro.asStateFlow()

    fun atualizarFiltro( novoFiltro : String ) {
        _filtro.value = novoFiltro
    }

    val lista = combine( _lista, _filtro ) {
        listaOriginal, filtroOriginal ->
        if (listaOriginal.isEmpty()) {
            listaOriginal
        } else {
            listaOriginal.filter{ objTurma ->
                objTurma.nomeDisciplina.contains(filtroOriginal, ignoreCase = true)
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    var indiceId : Long = 2



    var id : MutableState<String> = mutableStateOf("")
    var codigo : MutableState<String> = mutableStateOf("")
    var nomeDisciplina : MutableState<String> = mutableStateOf("")
    var semestre : MutableState<String> = mutableStateOf("")
    var ano : MutableState<String> = mutableStateOf("")

    val backStack = NavBackStack<TurmaRotas>(TurmaRotas.listagem)

    fun apagar( id : Long ) {
        val turmaEncontrada = _lista.value.firstOrNull { turma -> turma.id == id }
        if (turmaEncontrada != null) {
            _lista.update { listaOriginal -> listaOriginal - turmaEncontrada }
            mandarMensagem("Turma $id apagada com sucesso!", SnackbarDuration.Long)
        } else {
            mandarMensagem("Turma $id não encontrada!", SnackbarDuration.Long)
        }
    }

    fun editar( id : Long ) {
        val turmaEncontrada = _lista.value.firstOrNull { turma -> turma.id == id }
        if (turmaEncontrada != null) {
            this.id.value = turmaEncontrada.id.toString()
            nomeDisciplina.value = turmaEncontrada.nomeDisciplina
            codigo.value = turmaEncontrada.codigo
            semestre.value = turmaEncontrada.semestre.toString()
            ano.value = turmaEncontrada.ano.toString()
            backStack.clear()
            backStack.add(TurmaRotas.formulario)
            mandarMensagem("Editando turma $id", SnackbarDuration.Long)
        }
    }

    fun salvar() {
        var turma = Turma(
            codigo = codigo.value,
            nomeDisciplina = nomeDisciplina.value,
            semestre = semestre.value.toIntOrNull() ?: 1,
            ano = ano.value.toIntOrNull() ?: 2026
        )
        if (id.value != "") {
            val idNumber = id.value.toLong()
            val turmaEncontrada = _lista.value.firstOrNull { turma -> turma.id == idNumber }
            if (turmaEncontrada != null) {
                _lista.update {
                    listaOriginal -> listaOriginal.map {
                        turmaOriginal -> if(turma.id == idNumber) {
                            turma.copy( id = idNumber)
                        } else {
                            turmaOriginal
                        }
                    }
                }
            }
        } else {
            indiceId = indiceId + 1
            turma = turma.copy(id = indiceId)
            _lista.update { listaOriginal -> listaOriginal + turma }
        }
        id.value = ""
        codigo.value = ""
        nomeDisciplina.value = ""
        semestre.value = ""
        ano.value = ""
        backStack.clear()
        backStack.add(TurmaRotas.listagem)
        mandarMensagem("Turma ${turma.codigo} salva com sucesso!", SnackbarDuration.Long)
    }

    fun cancelar() {
        codigo.value = ""
        nomeDisciplina.value = ""
        semestre.value = ""
        ano.value = ""
        mandarMensagem("Operação cancelada!", SnackbarDuration.Long)
        backStack.clear()
        backStack.add(TurmaRotas.listagem)
    }

}
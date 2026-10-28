package edu.curso.pulsefront.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavBackStack
import edu.curso.pulsefront.model.Turma
import edu.curso.pulsefront.ui.navigation.ModulosRotas
import edu.curso.pulsefront.ui.navigation.TurmaRotas

class TurmaViewModel : ViewModel() {
    val lista : SnapshotStateList<Turma> = mutableStateListOf()
    val listaView : SnapshotStateList<Turma> = mutableStateListOf()

    var indiceId : Long = 0

    var filtro : MutableState<String> = mutableStateOf("")

    var id : MutableState<String> = mutableStateOf("")
    var codigo : MutableState<String> = mutableStateOf("")
    var nomeDisciplina : MutableState<String> = mutableStateOf("")
    var semestre : MutableState<String> = mutableStateOf("")
    var ano : MutableState<String> = mutableStateOf("")
    var mensagem : MutableState<String> = mutableStateOf("")

    val navigation : MutableState<String> = mutableStateOf("LISTA")

    val backStack = NavBackStack<TurmaRotas>(TurmaRotas.listagem)

    fun updateListaView() {
        listaView.clear()
        if (filtro.value.isEmpty()) {
            listaView.addAll(lista)
        } else {
            listaView.addAll(lista.filter { it.nomeDisciplina.contains(filtro.value, ignoreCase = true) })
        }
    }

    fun atualizarFiltro( novoFiltro : String ) {
        filtro.value = novoFiltro
        updateListaView()
    }

    fun apagar( id : Long ) {
        val tamanho = lista.size
        lista.removeAll { it.id == id }
        mensagem.value = if (lista.size < tamanho) {
            "Turma $id apagada com sucesso!"
        } else {
            "Turma $id não encontrada!"
        }
        updateListaView()
    }

    fun editar( id : Long ) {
        val turma = lista.find { it.id == id }
        if (turma != null) {
            this.id.value = turma.id.toString()
            nomeDisciplina.value = turma.nomeDisciplina
            codigo.value = turma.codigo
            semestre.value = turma.semestre.toString()
            ano.value = turma.ano.toString()
            navigation.value = "FORM"
            mensagem.value = "Editando turma $id"
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
            val indice = lista.indexOfFirst { it.id == id.value.toLong() }
            if (indice >= 0) {
                turma = turma.copy(id = id.value.toLong())
                lista[indice] = turma
            }
        } else {
            indiceId = indiceId + 1
            turma = turma.copy(id = indiceId)
            lista.add(turma)
        }
        id.value = ""
        codigo.value = ""
        nomeDisciplina.value = ""
        semestre.value = ""
        ano.value = ""
        updateListaView()
        mensagem.value = "Turma ${turma.codigo} salva com sucesso!"
        navigation.value = "LISTA"
    }

    fun cancelar() {
        codigo.value = ""
        nomeDisciplina.value = ""
        semestre.value = ""
        ano.value = ""
        updateListaView()
        mensagem.value = "Operação cancelada!"
        navigation.value = "LISTA"
    }

}
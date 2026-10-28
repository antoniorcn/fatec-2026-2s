package edu.curso.pulsefront.viewmodel

import androidx.compose.material3.SnackbarDuration
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavBackStack
import edu.curso.pulsefront.ui.navigation.CursoRotas
import edu.curso.pulsefront.ui.navigation.TurmaRotas

class CursosViewModel(
    private val mandarMensagem : ( String, SnackbarDuration) -> Unit
) : ViewModel() {
    val backStack = NavBackStack<CursoRotas>(CursoRotas.listagem)

}
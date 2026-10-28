package edu.curso.pulsefront.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavBackStack
import edu.curso.pulsefront.ui.navigation.CursoRotas
import edu.curso.pulsefront.ui.navigation.TurmaRotas

class CursosViewModel : ViewModel() {
    val backStack = NavBackStack<CursoRotas>(CursoRotas.listagem)

}
package edu.curso.pulsefront.viewmodel

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavBackStack
import edu.curso.pulsefront.ui.navigation.ModulosRotas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PrincipalViewModel(private val scope: CoroutineScope) : ViewModel() {

    val backStackModules = NavBackStack<ModulosRotas>(ModulosRotas.turmas)
    val drawerState = DrawerState(DrawerValue.Closed)

    fun fecharGaveta() {
        scope.launch {
            drawerState.close()
        }
    }

    fun abrirGaveta() {
        scope.launch {
            drawerState.open()
        }
    }
}
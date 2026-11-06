package edu.curso.pulsefront.viewmodel

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavBackStack
import edu.curso.pulsefront.ui.navigation.ModulosRotas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PrincipalViewModel(private val scope: CoroutineScope) : ViewModel() {

    val backStackModules = NavBackStack<ModulosRotas>(ModulosRotas.turmas)
    val drawerState = DrawerState(DrawerValue.Closed)

    val snack = SnackbarHostState()

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

    fun mostrarMensagem( mensagem : String,
                         duracao : SnackbarDuration = SnackbarDuration.Short
    ) {
        scope.launch {
            snack.showSnackbar(
                message = mensagem,
                duration = duracao
            )
        }
    }
}
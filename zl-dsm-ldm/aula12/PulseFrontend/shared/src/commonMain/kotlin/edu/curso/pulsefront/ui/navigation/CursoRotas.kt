package edu.curso.pulsefront.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface CursoRotas : NavKey {
    @Serializable
    object formulario : CursoRotas
    @Serializable
    object listagem : CursoRotas
}

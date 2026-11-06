package edu.curso.pulsefront.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface ModulosRotas : NavKey {
    @Serializable
    object turmas : ModulosRotas
    @Serializable
    object cursos : ModulosRotas
}
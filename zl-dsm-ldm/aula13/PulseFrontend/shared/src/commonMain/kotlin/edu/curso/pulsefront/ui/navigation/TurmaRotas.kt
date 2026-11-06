package edu.curso.pulsefront.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface TurmaRotas : NavKey {
    @Serializable
    object formulario : TurmaRotas
    @Serializable
    object listagem : TurmaRotas
}
//
//val rota = TurmaRotas.formulario
//
//fun main() {
//    when (rota) {
//        TurmaRotas.formulario -> {}
//        TurmaRotas.listagem -> {}
//    }
//}
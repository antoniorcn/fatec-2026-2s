package edu.curso.pulsefront

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import edu.curso.pulsefront.ui.view.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PulseFrontend",
    ) {
        App()
    }
}
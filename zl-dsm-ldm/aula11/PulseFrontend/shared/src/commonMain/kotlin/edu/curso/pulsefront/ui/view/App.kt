package edu.curso.pulsefront.ui.view

import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.curso.pulsefront.viewmodel.TurmaViewModel
import org.jetbrains.compose.resources.painterResource
import pulsefrontend.shared.generated.resources.Res
import pulsefrontend.shared.generated.resources.add_circle_24px
import pulsefrontend.shared.generated.resources.menu_24px

@Composable
@Preview
fun App() {

    val turmaViewModel = viewModel { TurmaViewModel() }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        Icon(
                            painterResource(Res.drawable.menu_24px),
                            contentDescription = "Menu",
                        )
                    },
                    title = { Text("Gestão de Turmas")
                    },
                    actions =  {
                        TextField(
                            value = turmaViewModel.filtro.value,
                            onValueChange = { turmaViewModel.atualizarFiltro(it) },
                            placeholder = { Text("Filtrar") },
                            modifier = Modifier.width(100.dp)
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar{ Text( turmaViewModel.mensagem.value ) }
            },
            floatingActionButton = {
                Button(onClick = { turmaViewModel.navigation.value = "FORM" }) {
                    Icon(
                        painterResource(Res.drawable.add_circle_24px),
                        contentDescription = "Add",
                        tint = Color.Yellow
                    )
                }
            }
        ) {
            if (turmaViewModel.navigation.value == "FORM") {
                Formulario( it, turmaViewModel )
            } else if (turmaViewModel.navigation.value == "LISTA") {
                Listagem( it, turmaViewModel )
            }
        }
    }
}
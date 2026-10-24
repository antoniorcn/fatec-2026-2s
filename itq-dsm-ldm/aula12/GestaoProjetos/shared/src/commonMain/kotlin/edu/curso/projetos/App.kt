package edu.curso.projetos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.curso.projetos.ui.screen.ProjetoFormulario
import edu.curso.projetos.ui.screen.ProjetoListagem
import edu.curso.projetos.ui.viewmodel.ProjetoViewModel
import gestaoprojetos.shared.generated.resources.Res
import gestaoprojetos.shared.generated.resources.menu_24px
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun App() {
    val vm = viewModel{ ProjetoViewModel() }
    val filtro = vm.filtro.collectAsState()
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon  = {
                        Icon(
                            painter = painterResource(Res.drawable.menu_24px),
                            contentDescription = "Menu",
                        )
                    },
                    title = {
                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()) {
                            Text("Gestão de Projetos II")
                            Spacer(modifier = Modifier.size(4.dp))
                            TextField( modifier = Modifier.width(150.dp),
                                value = filtro.value, onValueChange = {vm.atualizarFiltro(it)},
                                placeholder = { Text("Filtro") })
                        }
                    }
                )
            },
            floatingActionButton = {
                Button(onClick = vm::novoProjeto) {
                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "Adicionar",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        ) { contentPadding ->
            if (vm.tela.value == "form") {
                ProjetoFormulario(contentPadding, vm)
            } else {
                ProjetoListagem(contentPadding, vm)
            }
        }
    }
}
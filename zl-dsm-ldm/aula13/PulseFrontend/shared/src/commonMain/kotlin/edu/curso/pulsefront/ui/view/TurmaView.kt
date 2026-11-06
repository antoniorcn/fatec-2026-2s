package edu.curso.pulsefront.ui.view

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavBackStack
import edu.curso.pulsefront.ui.components.MeuTextField
import edu.curso.pulsefront.ui.navigation.TurmaRotas
import edu.curso.pulsefront.viewmodel.TurmaViewModel
import org.jetbrains.compose.resources.painterResource
import pulsefrontend.shared.generated.resources.Res
import pulsefrontend.shared.generated.resources.delete_24px
import pulsefrontend.shared.generated.resources.edit_document_24px
import pulsefrontend.shared.generated.resources.list_24px

@Composable
fun Formulario( padding : PaddingValues,
                turmaViewModel : TurmaViewModel) {
    Column (modifier = Modifier.padding( padding)) {
        MeuTextField(
            label = "Id",
            placeholder = "Id da turma",
            value = turmaViewModel.id.value,
        )
        MeuTextField(
            value = turmaViewModel.codigo.value,
            onValueChange = { novoTexto ->
                turmaViewModel.codigo.value = novoTexto
                // println("Codigo: ${codigo.value}")
            },
            label = "Codigo",
            placeholder = "Codigo da turma"
        )
        MeuTextField(
            value = turmaViewModel.nomeDisciplina.value,
            onValueChange = { turmaViewModel.nomeDisciplina.value = it },
            label = "Nome Disciplina",
            placeholder = "Nome da disciplina"
        )
        MeuTextField(
            value = turmaViewModel.semestre.value,
            onValueChange = { turmaViewModel.semestre.value = it },
            label = "Semestre",
            placeholder = "Semestre"
        )
        MeuTextField(
            value = turmaViewModel.ano.value,
            onValueChange = { turmaViewModel.ano.value = it },
            label = "Ano",
            placeholder = "Ano de inicio da turma"
        )
        Text("Codigo: ${turmaViewModel.codigo.value}")
        Row (modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {turmaViewModel.salvar()} ) {
                Text("Salvar")
            }
            Button(onClick = {turmaViewModel.cancelar()} ) {
                Text("Cancelar")
            }
        }

    }
}

@Composable
fun Listagem( padding : PaddingValues, turmaViewModel: TurmaViewModel ) {
    val lista = turmaViewModel.lista.collectAsState()
//    var currentOffset = remember { mutableStateOf(0f) }
//    val maxScroll = 500f // Limite máximo de scroll em pixels
//
//    val scrollableState = ScrollableState { delta ->
//        val oldOffset = currentOffset
//        // Garante que o novo offset fique entre 0 e o limite máximo
//        currentOffset.value = (currentOffset.value + delta).coerceIn(0f, maxScroll)
//
//        // Retorna exatamente a diferença consumida
//        val consumed = currentOffset.value - oldOffset.value
//        consumed
//    }
//    Column(modifier = Modifier.padding( padding )
//        .scrollable( orientation = Orientation.Vertical,
//            state = scrollableState)
//    ) {
//        for (turma in lista.value) {
//    ...
//        }
//    }
    LazyColumn(
        modifier = Modifier.padding( padding ),
    ) {
        items(lista.value ) { turma ->
            Row (modifier = Modifier.fillMaxWidth()
                .height(150.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .border(2.dp, Color.Gray, shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Column(modifier = Modifier.weight(5f)) {
                    Text("Id: ${turma.id}")
                    Text("Codigo: ${turma.codigo}")
                    Text("Nome Disciplina: ${turma.nomeDisciplina}")
                    Text("Semestre: ${turma.semestre}")
                    Text("Ano: ${turma.ano}")
                }
                Column(verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight().weight(1f)) {
                    IconButton(
                        onClick = { turmaViewModel.editar(turma.id) }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.edit_document_24px),
                            contentDescription = "Editar"
                        )
                    }
                    IconButton(
                        onClick = { turmaViewModel.apagar(turma.id) }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.delete_24px),
                            contentDescription = "Delete"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TurmaNavigationBottomBar( backstack : NavBackStack<TurmaRotas> ) {
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(Res.drawable.edit_document_24px),
                    contentDescription = "Formulario"  )
            },
            selected = backstack.last() == TurmaRotas.formulario,
            onClick = {
                backstack.clear()
                backstack.add( TurmaRotas.formulario )
            }
        )
        NavigationBarItem(
            icon = { Icon(
                painter = painterResource(Res.drawable.list_24px),
                contentDescription = "Listagem"
            )},
            selected = backstack.last() == TurmaRotas.listagem,
            onClick = {
                backstack.clear()
                backstack.add(TurmaRotas.listagem )
            }
        )
    }
}


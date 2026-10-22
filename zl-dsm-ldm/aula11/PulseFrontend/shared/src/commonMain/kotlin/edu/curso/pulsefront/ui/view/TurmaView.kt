package edu.curso.pulsefront.ui.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import edu.curso.pulsefront.ui.components.MeuTextField
import edu.curso.pulsefront.viewmodel.TurmaViewModel
import org.jetbrains.compose.resources.painterResource
import pulsefrontend.shared.generated.resources.Res
import pulsefrontend.shared.generated.resources.delete_24px
import pulsefrontend.shared.generated.resources.edit_document_24px

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
    Column(modifier = Modifier.padding( padding )) {
        for (turma in turmaViewModel.listaView) {
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
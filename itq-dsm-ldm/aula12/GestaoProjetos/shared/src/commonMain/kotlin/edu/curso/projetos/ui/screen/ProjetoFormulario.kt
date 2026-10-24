package edu.curso.projetos.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import edu.curso.projetos.ui.viewmodel.ProjetoViewModel

@Composable
fun ProjetoFormulario( innerPadding : PaddingValues,
                       vm : ProjetoViewModel
) {
    Column {
        TextField(
            // O encadeamento é baseado no padrão de projetos chamado Fluency
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Cyan)
                .padding(innerPadding ),
            value = vm.id.value, onValueChange = { },
            readOnly = true,
            placeholder = { Text("ID: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = vm.nome.value, onValueChange = { txt -> vm.nome.value = txt },
            placeholder = { Text("Nome: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = vm.descricao.value, onValueChange = { txt -> vm.descricao.value = txt },
            placeholder = { Text("Descrição: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = vm.dataInicio.value, onValueChange = { txt -> vm.dataInicio.value = txt },
            placeholder = { Text("Data Inicio: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = vm.dataFim.value, onValueChange = { txt -> vm.dataFim.value = txt },
            placeholder = { Text("Data Entrega: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = vm.status.value, onValueChange = { txt -> vm.status.value = txt },
            placeholder = { Text("Status: ") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.Cyan)
            .clickable { println("Clicado na linha")},
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Button( onClick = vm::salvar ) {
                Text("Salvar")
            }
//            Button( onClick = { vm.salvar() }) {
//                Text("Salvar")
//            }
            Button( onClick = vm::pesquisar ) {
                Text("Pesquisar")
            }
        }
    }
}
package edu.curso.projetos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.curso.projetos.model.Projeto
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.MutableState

val projetos = mutableListOf<Projeto>(
    Projeto(1, "Projeto 1", "Descrição do Projeto 1", "2024-01-01", "2024-06-30", "Em andamento"),
    Projeto(2, "Projeto 2", "Descrição do Projeto 2", "2024-01-01", "2024-06-30", "Em andamento"),
)

@Composable
fun ProjetoFormulario( innerPadding : PaddingValues,
                       tela: MutableState<String>){
    // Baseado em um padrao de projetos chamado Observer
    // Variaveis de estado, que quando alteradas, atualizam a tela automaticamente
    val nome = remember { mutableStateOf("") }
    val descricao = remember { mutableStateOf("") }
    val dataInicio = remember { mutableStateOf("") }
    val dataFim = remember { mutableStateOf("") }
    val status = remember { mutableStateOf("") }

    Column {
        TextField(
            // O encadeamento é baseado no padrão de projetos chamado Fluency
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Cyan)
                .padding(innerPadding ),
            value = "", onValueChange = { },
            placeholder = { Text("ID: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = nome.value, onValueChange = { txt -> nome.value = txt },
            placeholder = { Text("Nome: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = descricao.value, onValueChange = { txt -> descricao.value = txt },
            placeholder = { Text("Descrição: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = dataInicio.value, onValueChange = { txt -> dataInicio.value = txt },
            placeholder = { Text("Data Inicio: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = dataFim.value, onValueChange = { txt -> dataFim.value = txt },
            placeholder = { Text("Data Entrega: ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            value = status.value, onValueChange = { txt -> status.value = txt },
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
            Button( onClick = {
                val projeto =  Projeto(
                    0, nome=nome.value,
                    descricao=descricao.value,
                    dataInicio=dataInicio.value,
                    dataFim=dataFim.value,
                    status=status.value
                )
                projetos.add(projeto)
                tela.value = "list"
            } ) {
                Text("Salvar")
            }
            Button( onClick = {
                for (prj in projetos) {
                    if (prj.nome.contains( nome.value )) {
                        nome.value = prj.nome
                        descricao.value = prj.descricao
                        dataInicio.value = prj.dataInicio
                        dataFim.value = prj.dataFim
                        status.value = prj.status
                    }
                }
            } ) {
                Text("Pesquisar")
            }
        }
    }
}

@Composable
fun ProjetoListagem( innerPadding : PaddingValues){
    Column(modifier = Modifier.padding(innerPadding)) {
        for (projeto in projetos) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding( 16.dp )
                .background(Color.LightGray)
                .height(70.dp)
                .clickable { println("Clicado no projeto ${projeto.nome}") },
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = projeto.nome,
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = projeto.descricao,
                    modifier = Modifier.weight(1f),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview
fun App() {
    val tela = remember { mutableStateOf("list") }
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Gestão de Projetos") },
                    navigationIcon = {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                Button(onClick = {
                    tela.value = "form"
                }) {
                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "Adicionar",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        ) { contentPadding ->
            if (tela.value == "form") {
                ProjetoFormulario(contentPadding, tela)
            } else {
                ProjetoListagem(contentPadding)
            }
        }
    }
}
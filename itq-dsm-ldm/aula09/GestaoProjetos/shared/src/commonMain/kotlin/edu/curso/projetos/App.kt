package edu.curso.projetos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.curso.projetos.model.Projeto

var c = 60

@Composable
fun OlaMundo(a : Int, b : Int) {
    val soma : Int = a + b
    Column {
        Text(
            text = """Soma: $soma Lorem ipsum dolor sit amet, 
            |consectetur adipiscing elit, sed do eiusmod tempor 
            |incididunt ut labore et dolore magna aliqua.
            |Ut enim ad minim veniam, quis nostrud exercitation 
            |ullamco laboris nisi ut aliquip ex ea commodo consequat.
            |Duis aute irure dolor in reprehenderit in voluptate velit 
            |esse cillum dolore eu fugiat nulla pariatur. Excepteur sint 
            |occaecat cupidatat non proident, sunt in culpa qui officia 
            |deserunt mollit anim id est laborum.""".trimMargin(),
            color = Color.Red,
            maxLines = 2,
            overflow = TextOverflow.MiddleEllipsis
        )
//    Button(
//        onClick = { println("Botão clicado!") },
//        content = { Text("Clique aqui") }
//    )

        TextField(
            value = "Digite algo",
            onValueChange = { txt ->
                println("Texto digitado: $txt")
            }
        )
        Row {
            Button(
                onClick = { println("Botão Salvar clicado!") }
            ) {
                Text("Salvar")
            }
            Button(
                onClick = { println("Botão Pesquisar clicado!") }
            ) {
                Text("Pesquisar")
            }
        }
    }
}

val projetos = mutableListOf<Projeto>()

@Composable
fun ProjetoFormulario(){
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
                .padding(16.dp),
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
        Row {
            Button( onClick = {
                val projeto =  Projeto(
                    0, nome=nome.value,
                    descricao=descricao.value,
                    dataInicio=dataInicio.value,
                    dataFim=dataFim.value,
                    status=status.value
                )
                projetos.add(projeto)
            } ) {
                Text("Salvar")
            }
            Spacer(modifier = Modifier.width(6.dp))
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
@Preview
fun App() {
    MaterialTheme {
        ProjetoFormulario()
    }
}
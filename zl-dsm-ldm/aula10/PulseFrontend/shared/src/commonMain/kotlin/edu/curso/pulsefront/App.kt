package edu.curso.pulsefront

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.onDrag
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import pulsefrontend.shared.generated.resources.Res
import pulsefrontend.shared.generated.resources.add_circle_24px
import pulsefrontend.shared.generated.resources.menu_24px

val lista : MutableList<Turma> = mutableListOf()
var indiceId : Long = 0

@Composable
fun HelloWorld(texto : String) {
    Text(
        "Hello World Kotlin Multiplataforma $texto",
        color=Color.Magenta,
        maxLines = 2,
        overflow = TextOverflow.MiddleEllipsis,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposeDemonstration() {
    Column {
        HelloWorld("ABC123")
        HelloWorld("ABC123")
        HelloWorld("ABC")
        HelloWorld("123")
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Digite seu nome") }
        )
        Row {
            Button(onClick = {}) {
                Text("Salvar")
            }
            Button(onClick = {}) {
                Text("Pesquisar")
            }
        }
        Text(
            "Coloquei um text abaixo dos botões",
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp)
                .background(Color.Cyan, shape = RoundedCornerShape(32.dp))
                .border(2.dp, Color.Red,
                    shape = RoundedCornerShape(32.dp))
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .onDrag { println("Arrastando $it") }
        )
    }
}

@Composable
fun MeuTextField(   value : String = "",
                    onValueChange : (String) -> Unit = {},
                    label : String = "" ,
                    placeholder : String = "",
                    enabled : Boolean = true,
                    modifier : Modifier = Modifier ) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text( label ) },
        placeholder = { Text( placeholder ) },
        enabled = enabled,
        modifier = modifier.fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)

    )
}

// var codigo : MutableState<String> = mutableStateOf("T002")

@Composable
fun Formulario( padding : PaddingValues,
                codigo : MutableState<String>,
                nomeDisciplina : MutableState<String>,
                semestre : MutableState<String>,
                ano : MutableState<String>,
                salvar : () -> Unit = {},
                cancelar : () -> Unit = {}) {
    Column (modifier = Modifier.padding( padding)) {
        MeuTextField(
            label = "Id",
            placeholder = "Id da turma",
        )
        MeuTextField(
            value = codigo.value,
            onValueChange = { novoTexto ->
                codigo.value = novoTexto
                // println("Codigo: ${codigo.value}")
            },
            label = "Codigo",
            placeholder = "Codigo da turma"
        )
        MeuTextField(
            value = nomeDisciplina.value,
            onValueChange = { nomeDisciplina.value = it },
            label = "Nome Disciplina",
            placeholder = "Nome da disciplina"
        )
        MeuTextField(
            value = semestre.value,
            onValueChange = { semestre.value = it },
            label = "Semestre",
            placeholder = "Semestre"
        )
        MeuTextField(
            value = ano.value,
            onValueChange = { ano.value = it },
            label = "Ano",
            placeholder = "Ano de inicio da turma"
        )
        Text("Codigo: ${codigo.value}")
        Row (modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = salvar ) {
                Text("Salvar")
            }
            Button(onClick = cancelar ) {
                Text("Cancelar")
            }
        }

    }
}

@Composable
fun Listagem( padding : PaddingValues ) {
    Column(modifier = Modifier.padding( padding )) {
        for (turma in lista) {
            Column(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .border(2.dp, Color.Gray, shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text("Id: ${turma.id}")
                Text("Codigo: ${turma.codigo}")
                Text("Nome Disciplina: ${turma.nomeDisciplina}")
                Text("Semestre: ${turma.semestre}")
                Text("Ano: ${turma.ano}")
            }
        }
    }
}


@Composable
@Preview
fun App() {
    var codigo : MutableState<String> = remember{ mutableStateOf("") }
    var nomeDisciplina : MutableState<String> = remember{ mutableStateOf("") }
    var semestre : MutableState<String> = remember{ mutableStateOf("") }
    var ano : MutableState<String> = remember{ mutableStateOf("") }
    var mensagem : MutableState<String> = remember{ mutableStateOf("") }

    val navigation : MutableState<String> = remember{ mutableStateOf("LISTA") }

    val salvar = {
        indiceId = indiceId + 1
        val turma = Turma(
            id = indiceId,
            codigo = codigo.value,
            nomeDisciplina = nomeDisciplina.value,
            semestre = semestre.value.toIntOrNull() ?: 1,
            ano = ano.value.toIntOrNull() ?: 2026
        )
        lista.add(turma)
        codigo.value = ""
        nomeDisciplina.value = ""
        semestre.value = ""
        ano.value = ""
        mensagem.value = "Turma ${turma.codigo} salva com sucesso!"
        println("Salvando turma: $turma")
        println("Lista: $lista")
        navigation.value = "LISTA"
    }

    val cancelar = {
        codigo.value = ""
        nomeDisciplina.value = ""
        semestre.value = ""
        ano.value = ""
        mensagem.value = "Operação cancelada!"
        navigation.value = "LISTA"
    }

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
                    }
                )
            },
            bottomBar = {
                BottomAppBar{ Text( mensagem.value ) }
            },
            floatingActionButton = {
                Button(onClick = { navigation.value = "FORM" }) {
                    Icon(
                        painterResource(Res.drawable.add_circle_24px),
                        contentDescription = "Add",
                        tint = Color.Yellow
                    )
                }
            }
        ) {
            if (navigation.value == "FORM") {
                Formulario( it, codigo, nomeDisciplina, semestre, ano, salvar, cancelar )
            } else if (navigation.value == "LISTA") {
                Listagem( it )
            }
        }
    }

}
package edu.curso.projetos.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import edu.curso.projetos.model.Projeto
import edu.curso.projetos.ui.viewmodel.ProjetoViewModel
import gestaoprojetos.shared.generated.resources.Res
import gestaoprojetos.shared.generated.resources.delete_24px
import gestaoprojetos.shared.generated.resources.edit_square_24px
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjetoItem(projeto : Projeto,
                apagar : (Projeto) -> Unit = {},
                editar : (Projeto) -> Unit = {}) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding( 16.dp )
        .background(shape = RoundedCornerShape(20.dp), color = Color.LightGray)
        .height(100.dp)
        .border(shape = RoundedCornerShape(20.dp), width = 2.dp, color = Color.Black)
        .padding( vertical = 4.dp, horizontal = 16.dp ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
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
        Column {
            IconButton (onClick = { editar( projeto ) }) {
                Icon(
                    painter = painterResource(Res.drawable.edit_square_24px),
                    contentDescription = "Editar"
                )
            }
            IconButton (onClick = { apagar( projeto ) }) {
                Icon(
                    painter = painterResource(Res.drawable.delete_24px),
                    contentDescription = "Remover"
                )
            }
        }

    }
}

@Composable
fun ProjetoListagem( innerPadding : PaddingValues, vm : ProjetoViewModel){
    val lista = vm.projetosFiltrados.collectAsState()
    Column(modifier = Modifier.padding(innerPadding)) {
        for (projeto in lista.value) {
           ProjetoItem( projeto, apagar = vm::apagar, editar = vm::editar )
        }
    }
}
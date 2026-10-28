package edu.curso.pulsefront.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import edu.curso.pulsefront.ui.navigation.CursoRotas
import edu.curso.pulsefront.ui.navigation.TurmaRotas
import edu.curso.pulsefront.viewmodel.CursosViewModel
import edu.curso.pulsefront.viewmodel.TurmaViewModel
import org.jetbrains.compose.resources.painterResource
import pulsefrontend.shared.generated.resources.Res
import pulsefrontend.shared.generated.resources.edit_document_24px
import pulsefrontend.shared.generated.resources.list_24px

@Composable
fun CursoFormulario( padding : PaddingValues,
                cursoViewModel: CursosViewModel) {
    Column (modifier = Modifier.padding( padding)) {
        Text("Formulario do Curso")
    }
}

@Composable
fun CursoListagem( padding : PaddingValues, cursoViewModel: CursosViewModel ) {
    Column (modifier = Modifier.padding( padding)) {
        Text("Listagem do Curso")
    }
}

@Composable
fun CursoNavigationBottomBar( backstack : NavBackStack<CursoRotas>) {
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(Res.drawable.edit_document_24px),
                    contentDescription = "Formulario"  )
            },
            selected = backstack.last() == CursoRotas.formulario,
            onClick = {
                backstack.clear()
                backstack.add(CursoRotas.formulario )
            }
        )
        NavigationBarItem(
            icon = { Icon(
                painter = painterResource(Res.drawable.list_24px),
                contentDescription = "Listagem"
            )},
            selected = backstack.last() == CursoRotas.listagem,
            onClick = {
                backstack.clear()
                backstack.add(CursoRotas.listagem )
            }
        )
    }
}
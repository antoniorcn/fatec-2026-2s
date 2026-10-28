package edu.curso.pulsefront.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import edu.curso.pulsefront.ui.navigation.CursoRotas
import edu.curso.pulsefront.ui.navigation.ModulosRotas
import edu.curso.pulsefront.ui.navigation.TurmaRotas
import edu.curso.pulsefront.viewmodel.CursosViewModel
import edu.curso.pulsefront.viewmodel.PrincipalViewModel
import edu.curso.pulsefront.viewmodel.TurmaViewModel
import org.jetbrains.compose.resources.painterResource
import pulsefrontend.shared.generated.resources.*


@Composable
fun NavigationBottomBar( backStackModulos : NavBackStack<ModulosRotas>,
                         backStackTurmas : NavBackStack<TurmaRotas>,
                         backStackCursos : NavBackStack<CursoRotas>) {
    NavDisplay(
        backStack = backStackModulos,
        entryProvider = entryProvider<NavKey> {
            entry<ModulosRotas.turmas> {
                TurmaNavigationBottomBar(backStackTurmas)
            }
            entry<ModulosRotas.cursos> {
                CursoNavigationBottomBar(backStackCursos)
            }
        }
    )
}


@Composable
fun TurmasScreen(paddingIt: PaddingValues, turmaViewModel: TurmaViewModel) {
    NavDisplay(
        backStack = turmaViewModel.backStack,
        entryProvider = entryProvider<NavKey> {
            entry<TurmaRotas.listagem> {
                Listagem(paddingIt, turmaViewModel )
            }
            entry<TurmaRotas.formulario> {
                Formulario(paddingIt, turmaViewModel )
            }
        }
    )
}

@Composable
fun CursosScreen(paddingIt: PaddingValues, cursosViewModel: CursosViewModel) {
    NavDisplay(
        backStack = cursosViewModel.backStack,
        entryProvider = entryProvider<NavKey> {
            entry<CursoRotas.listagem> {
                CursoListagem(paddingIt, cursosViewModel )
            }
            entry<CursoRotas.formulario> {
                CursoFormulario(paddingIt, cursosViewModel )
            }
        }
    )
}

@Composable
fun DrawerView(principalVM: PrincipalViewModel) {
    val backStackModulos = principalVM.backStackModules
    ModalDrawerSheet {
        Text("Módulos do Sistema")
        Row( modifier = Modifier.clickable{
            backStackModulos.clear()
            backStackModulos.add(ModulosRotas.turmas)
            principalVM.fecharGaveta()

        }) {
            Icon( painter = painterResource(Res.drawable.group_24px)
                , contentDescription = "Turmas")
            Text("Turmas")
        }
        Row( modifier = Modifier.clickable{
            backStackModulos.clear()
            backStackModulos.add(ModulosRotas.cursos )
            principalVM.fecharGaveta()
        }) {
            Icon( painter = painterResource(Res.drawable.cast_for_education_24px)
                , contentDescription = "Cursos")
            Text("Cursos")
        }
    }
}

@Composable
fun CustomTitle( backStackModulos : NavBackStack<ModulosRotas>) {
    NavDisplay(
        backStack = backStackModulos,
        entryProvider = entryProvider<NavKey> {
            entry<ModulosRotas.turmas> {
                Text("Gestão de Turmas")
            }
            entry<ModulosRotas.cursos> {
                Text("Gestão de Cursos")
            }
        }
    )
}


@Composable
@Preview
fun App() {

    val scope = rememberCoroutineScope()
    val turmaViewModel = viewModel { TurmaViewModel() }
    val cursosViewModel = viewModel { CursosViewModel() }
    val principalViewModel = viewModel { PrincipalViewModel(scope) }

    MaterialTheme {
        ModalNavigationDrawer(
            drawerContent = { DrawerView(principalVM = principalViewModel) },
            drawerState = principalViewModel.drawerState
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        navigationIcon = {
                            Icon(
                                painterResource(Res.drawable.menu_24px),
                                contentDescription = "Menu",
                                modifier = Modifier.clickable {
                                    principalViewModel.abrirGaveta()
                                }
                            )
                        },
                        title = {
                            CustomTitle(backStackModulos = principalViewModel.backStackModules)
                        },
                        actions = {
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
                    // BottomAppBar{ Text( turmaViewModel.mensagem.value ) }
                    NavigationBottomBar( principalViewModel.backStackModules,
                        turmaViewModel.backStack,
                        cursosViewModel.backStack,)
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
            ) { paddingIt ->
                NavDisplay(
                    backStack = principalViewModel.backStackModules,
                    entryProvider = entryProvider<NavKey> {
                        entry<ModulosRotas.turmas> {
                            TurmasScreen(paddingIt, turmaViewModel)
                        }
                        entry<ModulosRotas.cursos> {
                            CursosScreen(paddingIt, cursosViewModel)
                        }
                    }
                )
            }
        }
    }
}
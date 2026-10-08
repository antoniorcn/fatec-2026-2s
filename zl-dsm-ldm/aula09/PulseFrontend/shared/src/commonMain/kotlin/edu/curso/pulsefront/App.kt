package edu.curso.pulsefront

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HelloWorld(texto : String) {
    Text(
        "Hello World Kotlin Multiplataforma $texto",
        color=Color.Magenta,
        maxLines = 2,
        overflow = TextOverflow.MiddleEllipsis,
    )
}

@Composable
@Preview
fun App() {
    // val texto = """Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Fugiat doloribus iure optio ullamco quo mollit est. Soluta cupiditate perferendis aliquip repudiandae incidunt tempora recusandae. Mollit laboris incididunt sit anim molestias irure recusandae voluptas velit placeat esse molestiae impedit. Voluptatem eos eaque ullamco quos esse deserunt ea consequatur voluptatibus tempora numquam repellendus natus. Laboriosam consequatur proident culpa itaque reprehenderit error doloremque ab quos ipsum sit."""
    val texto = "ABC123"

    MaterialTheme {
        Column {
            HelloWorld("ABC123")
            HelloWorld("ABC123")
            HelloWorld("ABC")
            HelloWorld("123")
    //        Button(onClick = {}, content={
    //            Text("Clique me")
    //        })
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
        }
    }

}
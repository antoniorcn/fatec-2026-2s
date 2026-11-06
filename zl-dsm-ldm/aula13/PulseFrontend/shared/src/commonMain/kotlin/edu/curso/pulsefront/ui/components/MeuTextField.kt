package edu.curso.pulsefront.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
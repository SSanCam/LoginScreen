import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun LoginScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pedir usuario
        OutlinedTextField(
            value = TODO(),
            onValueChange = TODO(),
            label = { Text(text = "Usuario") },
            modifier = Modifier
                .height(40.dp)
                .width(100.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Pedir clave
        OutlinedTextField(
            value = TODO(),
            onValueChange = TODO(),
            label = { Text(text = "Password") },
            modifier = Modifier
                .height(40.dp)
                .width(100.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
    }

}
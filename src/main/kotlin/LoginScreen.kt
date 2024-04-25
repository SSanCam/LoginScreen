import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun LoginScreen(onLoginClicked: (userName: String, password: String) -> Unit) {

    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pedir usuario
            OutlinedTextField(
                value = userName.value,
                onValueChange = { userName.value = it },
                label = { Text(text = "Usuario") },
                modifier = Modifier
                    .height(75.dp)
                    .width(300.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Pedir clave
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .height(75.dp)
                    .width(300.dp),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón log in
            Button(
                onClick = {
                    onLoginClicked(userName.value, password.value)
                },
                modifier = Modifier
                    .width(120.dp)
                    .height(75.dp)
                    .padding(20.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Log in",
                    color = Color.White
                )
            }
        }
    }

}

@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreen(onLoginClicked = { _, _ -> })
}
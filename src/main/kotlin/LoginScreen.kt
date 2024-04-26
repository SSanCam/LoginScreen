import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import jdk.jfr.Enabled

@Composable
@Preview
fun LoginScreen() {

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passVisible by remember { mutableStateOf(false) }
    val buttonEnabled = user.isNotBlank() && password.isNotBlank()


    MaterialTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),
            modifier = Modifier.fillMaxSize()
        ) {
            /*
            Usuario (user, { user= it})

            Usuario(user) {
                user = it
            }
             */

            Usuario(
                user = user,
                onUserChanged = { user = it }
            )

            Password(
                password = password,
                onPasswordChange = { password = it },
                passVisible = passVisible,
                onPassVisibleChange = { passVisible = it }
            )

            LoginButton(onClick = {user = ""; password = ""}, buttonEnabled)
        }
    }
}

@Composable
fun Usuario(
    user: String,
    onUserChanged: (String) -> Unit
) {

    OutlinedTextField(
        value = user,
        onValueChange = onUserChanged,
        label = { Text("Usuario") }
    )
}

@Composable
fun Password(
    password: String,
    onPasswordChange: (String) -> Unit,
    passVisible: Boolean,
    onPassVisibleChange: (Boolean) -> Unit
) {

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Contraseña") },
        visualTransformation = if (passVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconToggleButton(
                checked = passVisible,
                onCheckedChange = onPassVisibleChange
            ) {
                Icon(
                    imageVector = if (passVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun LoginButton(onClick: () -> Unit, enabled: Boolean) {
    Button(
        onClick = {
            onClick
        },
        enabled = enabled
    ) {
        Text(text = "Login")
    }
}
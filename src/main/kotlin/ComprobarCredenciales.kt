import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
@Preview
fun ComprobarCredenciales(username: String, password: String): Boolean {

    // Registro de usuarios:
    val registroUsuarios = mapOf(
        "Usiario1" to "Clave1",
        "Usuario2" to "clave2",
        "usuariot" to "tusuario"
    )

    return registroUsuarios.containsKey(username) && registroUsuarios[username] == password}
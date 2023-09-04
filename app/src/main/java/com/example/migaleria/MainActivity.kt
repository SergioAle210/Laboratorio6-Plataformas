package com.example.migaleria

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.migaleria.ui.theme.MiGaleriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiGaleriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardMenuPrincipal()
                }
            }
        }
    }
    @Deprecated("Deprecated in Java", ReplaceWith("finishAffinity()"))
    override fun onBackPressed() {
        finishAffinity()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardMenuPrincipal() {
    val context = LocalContext.current
    var text by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(
                text = "Iniciar sesión",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth(),
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(R.drawable.login_foreground),
                contentDescription = "Principal",
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .padding(1.dp)
                    .align(alignment = Alignment.TopStart),
                tint = Color.DarkGray
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(Color(232, 232, 232))
        )
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ){
            Image(
                painter = painterResource(R.drawable.sergio_campeon1),
                contentDescription = "Inicio",
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(10.dp)
                    .shadow(
                        elevation = 9.dp,
                        shape = RoundedCornerShape(20.dp),
                    ),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Usuario",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth(),
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )

            TextField(
                value = text,
                onValueChange = {
                    if (it.length <= 10) {
                        text = it
                    }
                    else Toast.makeText(context,"No se pueden ingresar mas de 10 caracteres", Toast.LENGTH_SHORT).show()
                },
                label = { Text("Correo electrónico") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                leadingIcon = ({
                    Icon(
                        painter = painterResource(R.drawable.person_login_foreground),
                        contentDescription = "Correo electrónico",
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .padding(1.dp),
                        tint = Color.DarkGray
                    )
                }),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray
                )
            )
            Text(
                text = "Contraseña",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth(),
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
            TextField(
                value = password,
                onValueChange = {
                    if (it.length <= 8) {
                        password = it
                    }
                    else Toast.makeText(context,"No se pueden ingresar mas de 8 caracteres", Toast.LENGTH_SHORT).show()
                                },
                label = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Go),
                leadingIcon = ({
                    Icon(
                        painter = painterResource(R.drawable.lock_foreground),
                        contentDescription = "Password",
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .padding(1.dp),
                        tint = Color.DarkGray
                    )
                }),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray
                )

            )
            Button(
                onClick = {
                    if (UsuariosValidos(text, password)) {
                        val intent = Intent(context, MainActivityGaleria::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        context.startActivity(intent)
                    }else{
                        Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .width(300.dp)
                    .padding(20.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .shadow(
                        elevation = 9.dp,
                        shape = RoundedCornerShape(20.dp),
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            )
            {
                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(7.dp)
                        .fillMaxWidth(),
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// Se crea un mapa con los usuarios y contraseñas validos
private val Usuarios = mapOf(
    "Sergio2104" to "12345678",
    "Sergio210" to "123456",
    "Sergio21" to "12345",
    "Sergio2" to "1234",
    "Sergio" to "123",
)

// Se valida que el usuario y contraseña ingresados sean validos
private fun UsuariosValidos(text: String, text2: String): Boolean {
    return Usuarios[text] == text2
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Mi UILogin"
)

@Composable
fun GreetingPreview() {
    MiGaleriaTheme {
        CardMenuPrincipal()
    }
}
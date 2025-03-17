package com.example.telacadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telacadastro.ui.theme.Orange
import com.example.telacadastro.ui.theme.OrangeIntermediary
import com.example.telacadastro.ui.theme.TelaCadastroTheme
import com.example.telacadastro.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaCadastroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Cadastro()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Cadastro() {
    Column (
        Modifier
            .fillMaxHeight()
            .background(Color(23,23,23))
    ) {
        Box(
            modifier = Modifier
                .height(150.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Orange, OrangeIntermediary, White
                        )
                    )
                )
                .fillMaxWidth()
        ) {
            // Vamos abrir um scopo para colocar a imagem dentro do box
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = "Descrição da Imagem",
                modifier = Modifier
                    .offset(y = (50).dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
                    .size(150.dp)
            )
        }
        Spacer(modifier = Modifier.height(75.dp))

        // Desta forma o modifier.padding servirá para todos os componentes dentro da coluna

        Column (Modifier.padding(16.dp) .align(Alignment.CenterHorizontally)) {
            Text(
                text = "Tela de Cadastro",
                fontSize = 35.sp, fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Orange
            )
        }
        Column (
            Modifier
                .padding(24.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Digite os seus dados",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Orange,
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Nome()
            Spacer(modifier = Modifier.height(25.dp))
            Telefone()
            Spacer(modifier = Modifier.height(25.dp))
            Curso()
            Spacer(modifier = Modifier.height(25.dp))
            Serie()
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                modifier = Modifier
                    .size(height = 60.dp, width = 120.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Enviar",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun Nome() {
    var nome by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = nome,
        onValueChange = {
            nome = it
        },
        label = { Text(text = "Nome") },
        placeholder = { Text(text = "Digite o seu nome") },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Orange,
            unfocusedLabelColor = Orange,
            unfocusedContainerColor = Color(46,46,46),
            unfocusedTextColor = Color.White,

            focusedIndicatorColor = Orange,
            focusedLabelColor = Orange,
            focusedContainerColor = Color(60,60,60),
            focusedTextColor = Color.White,

            cursorColor = Orange

        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            // Serve para quando der o enter ele ir para o próximo campo
            imeAction = ImeAction.Next
        )
    )
}

@Composable
fun Telefone() {
    var telefone by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = telefone,
        onValueChange = {
            telefone = it
        },
        label = { Text(text = "Telefone") },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Orange,
            unfocusedLabelColor = Orange,
            unfocusedContainerColor = Color(46,46,46),
            unfocusedTextColor = Color.White,

            focusedIndicatorColor = Orange,
            focusedLabelColor = Orange,
            focusedContainerColor = Color(60,60,60),
            focusedTextColor = Color.White,

            cursorColor = Orange

        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            // Serve para quando der o enter ele ir para o próximo campo
            imeAction = ImeAction.Next
        ),
        placeholder = { Text(text = "Digite o seu telefone") },

    )
}

@Composable
fun Curso() {
    var curso by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = curso,
        onValueChange = {
            curso = it
        },
        label = { Text(text = "Curso") },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Orange,
            unfocusedLabelColor = Orange,
            unfocusedContainerColor = Color(46,46,46),
            unfocusedTextColor = Color.White,

            focusedIndicatorColor = Orange,
            focusedLabelColor = Orange,
            focusedContainerColor = Color(60,60,60),
            focusedTextColor = Color.White,

            cursorColor = Orange

        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            // Serve para quando der o enter ele ir para o próximo campo
            imeAction = ImeAction.Next
        ),
        placeholder = { Text(text = "Digite o seu curso") },
    )
}

@Composable
fun Serie() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Série") },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Orange,
            unfocusedLabelColor = Orange,
            unfocusedContainerColor = Color(46,46,46),
            unfocusedTextColor = Color.White,

            focusedIndicatorColor = Orange,
            focusedLabelColor = Orange,
            focusedContainerColor = Color(60,60,60),
            focusedTextColor = Color.White,

            cursorColor = Orange

        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            // Serve para quando der o enter ele ir para o próximo campo
            imeAction = ImeAction.Done
        ),
        placeholder = { Text(text = "Digite a sua série") },
    )
}
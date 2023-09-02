package com.example.migaleria

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.migaleria.ui.theme.MiGaleriaTheme

class MainActivityGaleria : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiGaleriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardMenuGaleria()
                }
            }
        }
    }
}

@Composable
fun CardMenuGaleria() {
    val context = LocalContext.current
    var result by remember { mutableStateOf( 1) }
    val imageResource = when(result){
        1 -> R.drawable.sergio1
        2 -> R.drawable.sergio2
        3 -> R.drawable.sergio3
        4 -> R.drawable.sergio12
        5 -> R.drawable.sergio11
        6 -> R.drawable.sergio6
        7 -> R.drawable.sergio7
        8 -> R.drawable.sergio8
        9 -> R.drawable.sergio13
        else -> R.drawable.sergio10
    }
    val textoResource = when(result){
        1 -> "La aguja. Whashington."
        2 -> "Pasillo de arboles. Whashington."
        3 -> "La casa blanca. Whashington."
        4 -> "Universidad del Valle de Guatemala. Guatemala."
        5 -> "Oceana. Guatemala."
        6 -> "Theodoro Palacio Flores - 2. Guatemala."
        7 -> "La Aguja. Whashington DC."
        8 -> "One World Trade Center. New York City."
        9 -> "Niagara Falls. New York City."
        else -> "Estatua de Abraham Lincoln. Whashington."
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,

    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    context.startActivity(intent)
                  },
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
                    .background(Color.Transparent)
                    .padding(0.dp, 3.dp, 5.dp, 0.dp)
                    .shadow(
                        elevation = 9.dp,
                        shape = RoundedCornerShape(20.dp),
                    ),
                colors = ButtonDefaults.buttonColors(Color.White),
            )
            {
                Icon(
                    painter = painterResource(R.drawable.power_foreground),
                    contentDescription = "Power",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    tint = Color.Red
                )
            }

        }
        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .shadow(
                    elevation = 9.dp,
                    shape = RoundedCornerShape(20.dp),
                ),
            shape = RoundedCornerShape(20.dp),
            content = {
                Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .padding(40.dp)
                    .height(400.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )}
        )
        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .border(
                    width = 2.dp,
                    color = Color(253, 254, 254, 0),
                    shape = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp)
                )
                .clip(RoundedCornerShape(5.dp)),
            color = Color(146, 179, 245)
        ) {
            Column {
                Text(
                    text = "Lugar: $textoResource",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Justify,
                )
                Text(
                    text = "By. Sergio Orellana 221122",
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        {
            Button(
                onClick = {
                    if (result > 1) {
                        result -= 1
                    }else{
                        result = 10
                    }
                },
                modifier = Modifier
                    .padding(20.dp)
                    .width(150.dp)
                    .shadow(
                        elevation = 9.dp,
                        shape = RoundedCornerShape(20.dp),
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray
                )
            ){
                Text(
                    text = "Previuos",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(5.dp),
                    fontStyle = FontStyle.Normal
                )
            }
            Button(
                onClick = {
                    if (result < 10) {
                        result += 1
                    }else{
                        result = 1
                    }                },
                modifier = Modifier
                    .padding(15.dp)
                    .width(150.dp)
                    .shadow(
                        elevation = 9.dp,
                        shape = RoundedCornerShape(20.dp),
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray
                )
            ){
                Text(
                    text = "Next",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(5.dp),
                    fontStyle = FontStyle.Normal
                )
            }
        }

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Mi UIGaleria"
)

@Composable
fun GreetingPreviewGaleria() {
    MiGaleriaTheme {
        CardMenuGaleria()
    }
}

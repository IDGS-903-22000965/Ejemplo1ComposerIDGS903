package com.cortez.ejemplo1composeridgs903

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cortez.ejemplo1composeridgs903.R
import com.cortez.ejemplo1composeridgs903.ui.theme.Ejemplo1ComposerIDGS903Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta()
            }
        }
    }
}

@Composable
fun Imagen(){
    Image(
        painter = painterResource(id = R.drawable.goku),
        contentDescription = "goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.Gray)

    )
}

@Composable
fun Tarjeta(){
    Row {
        Imagen()
        Personaje()
    }

}

@Preview
@Composable
fun PreviewTajeta(){
    Tarjeta()
}

@Composable
fun Personaje(){
    Column {
        Text("Broly")
        Text("Son Goku")
        Imagen()
    }
}
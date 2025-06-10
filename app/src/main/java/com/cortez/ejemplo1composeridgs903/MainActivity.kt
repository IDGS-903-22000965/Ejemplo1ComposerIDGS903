package com.cortez.ejemplo1composeridgs903

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class PersonajeTarjeta(val title: String, val body: String)

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta(" goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla."),
    PersonajeTarjeta(" vegeta 1", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z."),
    PersonajeTarjeta(" Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("Android 17", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero"),

    )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1ComposerIDGS903Theme {
                    Tarjeta(tarjetas)
            }
        }
    }
}


@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        items(personajes) { personaje ->
            MyPersonajes(personaje)
        }
    }
}
@Composable
fun MyPersonajes(personaje: PersonajeTarjeta) {
    Card(
        modifier = Modifier.padding(8.dp)
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {


        Row(
            modifier = Modifier.padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ImageHeroe()
            Personajes(personaje)
        }
    }
}
@Composable
fun MyMessages(messages: List<PersonajeTarjeta>){
    Column {

    }
}


@Composable
fun Personaje(name: String, color: Color, style: androidx.compose.ui.text.TextStyle){
    Text(text = name)
}
@Composable
fun Personajes(personaje: PersonajeTarjeta) {
    Column {
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)
        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
    }
}
@Composable
fun ImageHeroe(){
    Image(
        painter = painterResource(id = R.drawable.vegetto),
        contentDescription = "Vegetto",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary)
    )
}


@Preview
@Composable
fun GreetingPreview() {
      Tarjeta(tarjetas)


}
package com.cortez.ejemplo1composeridgs903

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.Files.lines

data class PersonajeTarjeta(val title: String, val body: String)

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla."),
    PersonajeTarjeta("vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z."),
    PersonajeTarjeta("freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("android17", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tarjeta(tarjetas)
                }
            }
        }
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(personajes) { personaje ->
            MyPersonajes(personaje)
        }
    }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            ImageHeroe(personaje.title)
            Personajes(
                personaje = personaje,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun Personaje(name: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text = name, color = color, style = style, maxLines = lines)
}

@Composable
fun Personajes(personaje: PersonajeTarjeta, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.padding(start = 8.dp).clickable { expanded = !expanded
    }) {
        Personaje(
            personaje.title.replaceFirstChar { it.uppercase() },
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineSmall
        )
        Personaje(
            personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun ImageHeroe(imageName: String) {
    val context = LocalContext.current
    val imageResId = remember(imageName) {
        val resourceName = imageName.lowercase().replace(" ", "")
        val resId = context.resources.getIdentifier(
            resourceName,
            "drawable",
            context.packageName
        )
        if (resId != 0) resId else android.R.drawable.ic_menu_gallery
    }

    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "Imagen de $imageName",
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        Surface {
            Tarjeta(tarjetas)
        }
    }
}
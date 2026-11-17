package com.example.telegram.ui.screens

import android.graphics.Color.green
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telegram.R
import com.example.telegram.ui.theme.AzulClaro
import com.example.telegram.ui.theme.AzulTelegram
import com.example.telegram.ui.theme.FondoPerfil
import com.example.telegram.ui.theme.GrisClaro
import com.example.telegram.ui.theme.GrisMedio
import com.example.telegram.ui.theme.TelegramTheme
import com.example.telegram.ui.theme.TextoPrincipal
@Composable
fun ProfileScreen(nombre: String,  //nombre del perfil
                  activo: Boolean, //sirve para poner si esta en linea o no
                  numero: String,  //numero del perfil
                  modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoPerfil)
            .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        // Barra de arriba: un icono en cada esquina
        Row(
            modifier = Modifier
                .padding(top = 12.dp)
        ) {
            PonerIconosConFondo(R.drawable.ic_cuadricula)
            Spacer(Modifier.width(290.dp))
            PonerIconosConFondo(R.drawable.ic_tres_puntos)
        }

        // Foto de perfil: la misma función, pero grande y con la persona en blanco
        PonerIconosConFondo(
            icon = R.drawable.ic_persona,
            tamano = 110.dp,
            tamanoIcono = 110.dp,
            colorIcono = Color.White
        )

        Spacer(Modifier.height(12.dp))

        // Nombre y estado
        Text(
            text = nombre,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = if (activo) "en línea" else "última vez recientemente",
            fontSize = 15.sp,
            color = GrisMedio
        )

        Spacer(Modifier.height(20.dp))

        // Los 3 botones blancos
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BotonAccion(R.drawable.ic_camara_mas, "Establecer foto", Modifier.weight(1f))
            BotonAccion(R.drawable.ic_lapiz, "Editar info.", Modifier.weight(1f))
            BotonAccion(R.drawable.ic_tab_settings, "Ajustes", Modifier.weight(1f))
        }

        Spacer(Modifier.height(12.dp))

        // Tarjeta del número
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .tarjeta()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Text(text = numero, fontSize = 17.sp)
            Text(text = "Móvil", fontSize = 14.sp, color = GrisMedio)
        }

        Spacer(Modifier.height(16.dp))

        // Pestañas "Posts" / "Posts archivados"
        Row(
            modifier = Modifier
                .tarjeta(forma = CircleShape)
                .padding(4.dp)
        ) {
            Pestana("Posts", seleccionada = true)
            Pestana("Posts archivados", seleccionada = false)
        }

        // Mensaje de aun no hay histroias
        Spacer(Modifier.height(106.dp))
        Text(
            text = "Aún no hay historias…",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = "Publica fotos y videos para\nmostrarlos en tu perfil.",
            fontSize = 15.sp,
            color = GrisMedio,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(72.dp))

        // Botón azul "Añadir un post"
        Row(
            modifier = Modifier
                .tarjeta(color = AzulTelegram, forma = CircleShape)
                .padding(horizontal = 24.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_camara),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(22.dp)
            )
            Spacer(Modifier.width(10.dp))
            Text(text = "Añadir un post",
                fontSize = 16.sp, fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Composable
fun PonerIconosConFondo(
    icon: Int,
    modifier: Modifier = Modifier,
    tamano: Dp = 40.dp,
    tamanoIcono: Dp = 24.dp,
    colorFondo: Color = GrisClaro,
    colorIcono: Color = GrisMedio
){
    Box(
        modifier = modifier
            .size(tamano)
            .clip(CircleShape)
            .background(colorFondo),
            contentAlignment = Alignment.Center //por eso box
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = colorIcono,
            modifier = Modifier.size(tamanoIcono)
        )
    }
}

@Composable
fun BotonAccion(icon: Int, texto: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .tarjeta()
            .padding(vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = TextoPrincipal
        )
        Spacer(Modifier.height(6.dp))
        Text(text = texto, fontSize = 14.sp, color = TextoPrincipal)
    }
}

/** Una pestaña: si está seleccionada, fondo azul clarito y texto azul. */
@Composable
fun Pestana(texto: String, seleccionada: Boolean) {
    Text(
        text = texto,
        fontSize = 17.sp,
        fontWeight = FontWeight.Medium,
        color = if (seleccionada) AzulTelegram else GrisMedio,
        modifier = Modifier
            .tarjeta(
                color = if (seleccionada) AzulClaro else Color.Transparent,
                forma = CircleShape
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

/** Fondo con esquinas redondeadas. Por defecto blanco; se le puede pedir otro color u otra forma. */
fun Modifier.tarjeta(
    color: Color = Color.White,
    forma: Shape = RoundedCornerShape(16.dp)
): Modifier =
    this
        .clip(forma)
        .background(color)

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    TelegramTheme {
        ProfileScreen("Ernesto Berthon", true, "+591 (7) 7544385")
    }
}

package com.example.telegram.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telegram.ui.theme.AzulTelegram
import com.example.telegram.ui.theme.FondoPerfil
import com.example.telegram.ui.theme.GrisMedio
import com.example.telegram.ui.theme.TelegramTheme
import com.example.telegram.ui.theme.TextoPrincipal

// =====================================================================
//  PANTALLA DE CONTACTOS
// =====================================================================

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoPerfil)
            .padding(horizontal = 12.dp)
    ) {
        // Barra de arriba: Ordenar - Contactos - +
        Row(
            modifier = Modifier.padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Ordenar",
                fontSize = 17.sp,
                color = AzulTelegram,
                modifier = Modifier
                    .tarjeta(forma = CircleShape)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Text(
                text = "Contactos",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "+",
                fontSize = 24.sp,
                color = AzulTelegram,
                modifier = Modifier
                    .tarjeta(forma = CircleShape)
                    .padding(horizontal = 14.dp, vertical = 4.dp)
            )
        }

        Spacer(Modifier.height(12.dp))

        // Buscador (solo visual)
        Text(
            text = "Buscar",
            fontSize = 17.sp,
            color = GrisMedio,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .tarjeta(forma = CircleShape)
                .padding(vertical = 10.dp)
        )

        Spacer(Modifier.height(12.dp))

        // Lista de contactos en una tarjeta blanca
        Column(modifier = Modifier.tarjeta()) {
            Text(
                text = "Invitar amigos",
                fontSize = 17.sp,
                color = AzulTelegram,
                modifier = Modifier.padding(16.dp)
            )
            FilaContacto("Maurix", "últ. vez hace 5 minutos", Color(0xFFE57373))
            FilaContacto("Rodri C", "últ. vez hace 10 minutos", Color(0xFFBA68C8))
            FilaContacto("Ba bunny", "últ. vez hace 55 minutos", Color(0xFF64B5F6))
            FilaContacto("Tito", "últ. vez hace 1 hora", Color(0xFF4DB6AC))
            FilaContacto("Peso Pluma", "últ. vez hace 2 horas", Color(0xFFFFB74D))
        }
    }
}

// Una fila: círculo de color con la inicial + nombre + última vez
@Composable
fun FilaContacto(nombre: String, ultimaVez: String, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .tarjeta(color = color, forma = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nombre.first().toString(),
                fontSize = 20.sp,
                color = Color.White
            )
        }
        Spacer(Modifier.width(12.dp))
        Column {
            Text(text = nombre, fontSize = 17.sp, color = TextoPrincipal)
            Text(text = ultimaVez, fontSize = 14.sp, color = GrisMedio)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview() {
    TelegramTheme {
        ContactsScreen()
    }
}
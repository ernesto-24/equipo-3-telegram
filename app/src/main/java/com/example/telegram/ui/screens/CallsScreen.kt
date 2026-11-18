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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.compose.ui.graphics.Color
@Composable
fun CallsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoPerfil)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 12.dp)
    ) {
        // Barra de arriba: Editar - Llamadas - Teléfono
        Row(
            modifier = Modifier.padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Editar",
                fontSize = 17.sp,
                color = AzulTelegram,
                modifier = Modifier
                    .tarjeta(forma = CircleShape)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Text(
                text = "Llamadas",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "📞",
                fontSize = 18.sp,
                modifier = Modifier
                    .tarjeta(forma = CircleShape)
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        Spacer(Modifier.height(12.dp))

        // Buscador
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

        // Lista de llamadas en una tarjeta blanca
        Column(modifier = Modifier.tarjeta()) {
            FilaLlamada("Momix67", "↗ Saliente (12 min)", "10:45", Color(0xFFE57373))
            FilaLlamada("Rodri C", "↙ Perdida", "Ayer", Color(0xFFBA68C8), esPerdida = true)
            FilaLlamada("tito (el trans)", "↙ Entrante (4 min)", "Ayer", Color(0xFF64B5F6))
            FilaLlamada("felipe Laura", "↗ Saliente (28 min)", "15 nov", Color(0xFF9C27B0))
            FilaLlamada("Salvietti", "↙ Perdida", "14 nov", Color(0xFF4DB6AC), esPerdida = true)
            FilaLlamada("Kadir", "↙ Entrante (2 min)", "12 nov", Color(0xFF4CAF50))
        }

        Spacer(Modifier.height(12.dp))
    }
}
@Composable
fun FilaLlamada(
    nombre: String,
    tipoLlamada: String,
    fecha: String,
    colorAvatar: Color,
    esPerdida: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .tarjeta(color = colorAvatar, forma = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nombre.first().toString(),
                fontSize = 20.sp,
                color = Color.White
            )
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = nombre,
                fontSize = 17.sp,
                color = if (esPerdida) Color(0xFFE53935) else TextoPrincipal
            )
            Text(
                text = tipoLlamada,
                fontSize = 14.sp,
                color = GrisMedio
            )
        }
        Text(
            text = fecha,
            fontSize = 14.sp,
            color = GrisMedio
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CallsScreenPreview() {
    TelegramTheme {
        CallsScreen()
    }
}

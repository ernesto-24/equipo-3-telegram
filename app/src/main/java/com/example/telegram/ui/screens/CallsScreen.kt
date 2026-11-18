package com.example.telegram.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
    }
}

@Preview(showBackground = true)
@Composable
fun CallsScreenPreview() {
    TelegramTheme {
        CallsScreen()
    }
}
package com.example.telegram.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.telegram.ui.theme.TelegramTheme

// =====================================================================
//  PANTALLA DE AJUSTES (página 2 del deslizador)
//  Responsable: ____________
//
//  Aquí va toda la interfaz de Ajustes. Solo UI, sin lógica.
//  Podéis crear más @Composable en este archivo para dividir la pantalla
//  (p. ej. SettingsOption() para cada opción del menú), pero no toquéis MainActivity.kt.
// =====================================================================

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    // TODO: sustituir este placeholder por la interfaz de Ajustes
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Ajustes")
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    TelegramTheme {
        SettingsScreen()
    }
}

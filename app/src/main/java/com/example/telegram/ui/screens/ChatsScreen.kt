package com.example.telegram.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telegram.ui.theme.TelegramTheme

data class ChatData(
    val title: String,
    val message: String,
    val time: String,
    val unread: Int = 0,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatsScreen(modifier: Modifier = Modifier) {
    val chats = listOf(
        ChatData("ALGORITMICA II - SUPER B", "Rodo: https://github.com/rodo-code...", "Mon", 0, Color(0xFF00BCD4)),
        ChatData("Programación Funcional Mod 2", "Rodo: 9:00 PM - GRUPO 11...", "10/11", 0, Color(0xFFFF5722)),
        ChatData("ISC", "Alexis Marechal: Chicos buenas tardes. Les comunico qu...", "09/11", 0, Color(0xFF03A9F4)),
        ChatData("DTI", "Tabata: ¡Última oportunidad...", "06/11", 0, Color(0xFFE91E63)),
        ChatData("Rodo", "https://drive.google.com/file/d/...", "20/10", 0, Color(0xFF9C27B0)),
        ChatData("Kadir", "Estas solo mi amor?", "06/09", 1, Color(0xFF4CAF50)),
        ChatData("BangBros", "Renueva tu suscripcion", "25/08", 0, Color(0xFFAB47BC)),
        ChatData("Jefri", "Pasa la tarea", "18/08", 6, Color(0xFFFF9800)),
        ChatData("Tito", "No me baja", "04/08", 0, Color(0xFFFFC107))
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Chats", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    TextButton(onClick = { }) {
                        Text("Edit", color = Color(0xFF2388E4))
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)) {
            items(chats) { chat ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.size(50.dp).clip(CircleShape).background(chat.color),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = chat.title.take(1), color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = chat.title, fontWeight = FontWeight.Bold, maxLines = 1, modifier = Modifier.weight(1f, fill = false))
                            Text(text = chat.time, color = Color.Gray, fontSize = 12.sp)
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = chat.message, color = Color.Gray, fontSize = 14.sp, maxLines = 1, modifier = Modifier.weight(1f))
                            if (chat.unread > 0) {
                                Box(
                                    modifier = Modifier.size(20.dp).clip(CircleShape).background(Color(0xFF4CD964)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = chat.unread.toString(), color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
                Divider(color = Color.LightGray.copy(alpha = 0.2f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatsScreenPreview() {
    TelegramTheme {
        ChatsScreen()
    }
}

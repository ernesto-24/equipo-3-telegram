package com.example.telegram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import com.example.telegram.ui.screens.ChatsScreen
import com.example.telegram.ui.screens.ContactsScreen
import com.example.telegram.ui.screens.CallsScreen
import com.example.telegram.ui.screens.ProfileScreen
import com.example.telegram.ui.screens.SettingsScreen
import com.example.telegram.ui.theme.TelegramTheme

/**
 * MainActivity SOLO se encarga de cambiar entre pantallas deslizando.
 *
 * ⚠️ No escribáis aquí el contenido de vuestra pantalla.
 * Cada uno trabaja en SU archivo dentro de `ui/screens/`:
 *
 *   Página 0 → ChatsScreen.kt     (ui/screens/ChatsScreen.kt)
 *   Página 1 → ContactsScreen.kt  (ui/screens/ContactsScreen.kt)
 *   Página 2 → SettingsScreen.kt  (ui/screens/SettingsScreen.kt)
 *   Página 3 → ProfileScreen.kt   (ui/screens/ProfileScreen.kt)
 *
 * Deslizando hacia la izquierda se avanza en ese orden
 * (Chats → Contactos → Ajustes → Perfil).
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelegramTheme {
                MainPager()
            }
        }
    }
}

/** Pestañas de la barra inferior, en el mismo orden que las páginas. */
private enum class Tab(@StringRes val label: Int, @DrawableRes val icon: Int) {
    CHATS(R.string.tab_chats, R.drawable.ic_tab_chats),
    CONTACTS(R.string.tab_contacts, R.drawable.ic_tab_contacts),
    CALLS(R.string.tab_calls, R.drawable.ic_tab_calls),
    PROFILE(R.string.tab_profile, R.drawable.ic_tab_profile),
}

@Composable
fun MainPager() {
    val tabs = Tab.entries
    val pagerState = rememberPagerState(initialPage = 0) { tabs.size }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            // Barra de pestañas: se sincroniza con el deslizamiento en ambos sentidos
            NavigationBar {
                tabs.forEachIndexed { index, tab ->
                    NavigationBarItem(
                        selected = pagerState.currentPage == index,
                        onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                        icon = { Icon(painterResource(tab.icon), contentDescription = null) },
                        label = { Text(stringResource(tab.label)) }
                    )
                }
            }
        }
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { page ->
            when (page) {
                0 -> ChatsScreen()
                1 -> ContactsScreen()
                2 -> CallsScreen()
                3 -> ProfileScreen("Ernesto Berthon", true, "+591 7(7) 544385")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagerPreview() {
    TelegramTheme {
        MainPager()
    }
}

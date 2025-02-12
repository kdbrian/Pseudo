package io.github.kdbrian.pseudo.ui.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@Composable
fun RowScope.TabNavigationItem(
    modifier: Modifier = Modifier,
    tab: Tab,
) {

    val navigator = LocalTabNavigator.current

    NavigationBarItem(
        modifier = modifier,
        selected = navigator.current == tab,
        onClick = { navigator.current = tab },
        icon = {
            tab.options.icon?.let {
                Image(
                    painter = it,
                    contentDescription = tab.options.title,
                    modifier = Modifier.requiredSize(25.dp)
                )
            }
        },
        label = { Text(text = tab.options.title) }
    )
}

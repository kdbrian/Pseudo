package io.github.kdbrian.pseudo.features.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appRed
import io.github.kdbrian.pseudo.ui.util.BottomBarItem

@Composable
fun HomeBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    val currentRoute = navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = modifier.background(brush = LocalDefaultBackgroundBrush.current),
        containerColor = Color.Transparent
    ) {
        BottomBarItem.homeBottomSheetItems.forEachIndexed { _, item ->
            NavigationBarItem(
                selected = currentRoute.value?.destination?.route == item.route.toString(),
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    item.run {
                        if (icon != null) {
                            Icon(imageVector = icon, contentDescription = null)
                        } else if (image != null) {
                            Image(
                                painter = painterResource(image),
                                contentDescription = null,
                            )
                        }
                    }

                },
                label = {
                    Text(
                        text = item.title.toString(),
                        style = LocalTextStyle.current
                    )
                },
                alwaysShowLabel = false
            )

        }
    }


}


@Preview
@Composable
private fun HomeBottomBarPrev() {
    PseudoTheme {
        val navController = rememberNavController()
        HomeBottomBar(
            navController = navController
        )
    }
}
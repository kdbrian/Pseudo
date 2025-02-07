package io.github.kdbrian.pseudo.ui.util

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.nav.Route

sealed class BottomBarItem(
    val title: String? = null,
    @DrawableRes val image: Int? = null,
    val icon: ImageVector? = null,
    val route: Route,
) {

    data object HomeBottomBarItem : BottomBarItem(
        route = Route.Home,
        icon = Icons.Rounded.Home,
        title = "Home"
    )

    data object SearchBottomBarItem : BottomBarItem(
        route = Route.Search,
        icon = Icons.Rounded.Search,
        title = "Search"
    )

    data object SavesBottomBarItem : BottomBarItem(
        route = Route.Saves,
        image = R.drawable.book,
        title = "Saves"
    )

    companion object {
        val homeBottomSheetItems = listOf(
            HomeBottomBarItem,
            SearchBottomBarItem,
            SavesBottomBarItem
        )
    }
}
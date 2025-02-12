package io.github.kdbrian.pseudo.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import io.github.kdbrian.pseudo.features.catalogue.SearchScreen
import io.github.kdbrian.pseudo.features.saves.MySaves
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.util.TabNavigationItem

object HomeScreen : Screen {


    @Composable
    override fun Content() {

        TabNavigator(HomeScreenContent) { _ ->

            Scaffold(
                modifier = Modifier
                    .background(brush = LocalDefaultBackgroundBrush.current),
//                topBar = {
//                },
                bottomBar = {
                    BottomAppBar {
                        TabNavigationItem(tab = SearchScreen())
                        TabNavigationItem(tab = HomeScreenContent)
                        TabNavigationItem(tab = MySaves)
                    }
                }

            ) { padding ->
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)) {
                    CurrentTab()
                }

                /*
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(brush = LocalDefaultBackgroundBrush.current)
                ) {


                    TabRow(
                        selectedTabIndex = currentTab,
                        modifier = Modifier.fillMaxWidth(),
                        indicator = {
                        }
                    ) {

                        tabs.forEachIndexed { index, tab ->
                            Tab(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                selected = index == currentTab,
                                onClick = { currentTab = index },
                                text = {
                                    Text(
                                        text = tab,
                                        style = LocalTextStyle.current.copy(
                                            color = Color.DarkGray
                                        )
                                    )
                                }
                            )
                        }

                    }

                    when (currentTab) {
                        0 -> TrendingScreen()
                        1 -> MyFeedScreen()
                        else -> throw IllegalStateException()
                    }


                }

                 */
            }
        }

    }

}

@Preview
@Composable
private fun HomeScreenPrev() {
    PseudoTheme {
//        HomeScreen()
    }
}
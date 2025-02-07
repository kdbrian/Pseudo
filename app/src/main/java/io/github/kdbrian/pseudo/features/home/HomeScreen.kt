package io.github.kdbrian.pseudo.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import io.github.kdbrian.pseudo.features.catalogue.MyFeedScreen
import io.github.kdbrian.pseudo.features.catalogue.TrendingScreen
import io.github.kdbrian.pseudo.features.home.composables.HomeBottomBar
import io.github.kdbrian.pseudo.features.home.composables.HomeTopAppBar
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,

    ) {

    val navController = rememberNavController()
    var currentTab by remember {
        mutableIntStateOf(0)
    }
    val tabs = listOf(
        "Trending",
        "Feed"
    )


    Scaffold(
        modifier = Modifier
            .background(brush = LocalDefaultBackgroundBrush.current),
        topBar = {
            HomeTopAppBar()
        },
        bottomBar = {
            HomeBottomBar(navController = navController)
        }

    ) { paddingValues ->

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
    }

}

@Preview
@Composable
private fun HomeScreenPrev() {
    PseudoTheme {
        HomeScreen()
    }
}
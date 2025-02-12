package io.github.kdbrian.pseudo.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.features.catalogue.MyFeedTab
import io.github.kdbrian.pseudo.features.catalogue.TrendingTab
import io.github.kdbrian.pseudo.features.home.composables.HomeTopAppBar
import io.github.kdbrian.pseudo.ui.util.TabNavigationItem

object HomeScreenContent : Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = "Home",
            icon = painterResource(R.drawable.sharp_home_24)
        )

    @Composable
    override fun Content() {
//        Scaffold(
//            topBar = {
//            }
//        ) { paddingValues ->
            Column(modifier = Modifier
//                .padding(paddingValues)
            ) {
                HomeTopAppBar()

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TabNavigationItem(tab = TrendingTab)
                    TabNavigationItem(tab= MyFeedTab)
                }

                TabNavigator(TrendingTab) {
                    CurrentTab()
                }

            }
        }
    }

//}
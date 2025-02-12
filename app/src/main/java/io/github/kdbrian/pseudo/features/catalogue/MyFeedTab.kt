package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme


object MyFeedTab : Tab {

    override val options: TabOptions
        @Composable
        get() = remember {
            TabOptions(
                index = 0u,
                title = "My Feed"
            )
        }

    @Composable
    override fun Content() {
        val verticalScrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalScrollState)

        ) {
            repeat(10) {
                NotePreview()
            }
        }
    }

}




@Preview
@Composable
private fun MyFeedScreenPrev() {
    PseudoTheme {
    }
}
package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme


@Composable
fun TrendingScreen(modifier: Modifier = Modifier) {
    val verticalScrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(verticalScrollState)
    ) {
        repeat(10) {
            NotePreview()
        }
    }

}


@Preview
@Composable
private fun TrendingScreenPrev() {
    PseudoTheme {
        TrendingScreen()
    }
}
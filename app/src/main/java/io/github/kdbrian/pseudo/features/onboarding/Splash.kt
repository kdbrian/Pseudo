package io.github.kdbrian.pseudo.features.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.ui.composables.LoadingLogo
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush

@Composable
fun Splash(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalDefaultBackgroundBrush.current),
    ) {
        LoadingLogo(
            modifier = Modifier
                .width(150.dp)
                .align(Alignment.Center)
        )
    }

}
package io.github.kdbrian.pseudo.features.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.github.kdbrian.pseudo.ui.composables.LoadingLogo
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import kotlinx.coroutines.delay

//@Suppress("")
object Splash : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            delay(2000)
            navigator.replaceAll(OnBoardingScreen)
        }

        Box(
            modifier = Modifier
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
}
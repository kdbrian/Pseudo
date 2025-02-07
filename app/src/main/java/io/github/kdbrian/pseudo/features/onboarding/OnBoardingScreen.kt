package io.github.kdbrian.pseudo.features.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.ui.composables.LoadingLogo
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.composables.TextLogo
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onGetStarted : () -> Unit ={}
) {
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextLogo(
                modifier = Modifier
                    .offset(x = 18.dp, y = 6.dp)
                    .weight(1f)
            )

            IconButton(
                onClick = onGetStarted,
                modifier = Modifier.background(
                    brush = LocalDefaultBackgroundBrush.current,
                    shape = CircleShape
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
            }

        }
    }
}

@Preview
@Composable
private fun OnBoardingScreenPrev() {
    PseudoTheme {
        OnBoardingScreen()
    }
}
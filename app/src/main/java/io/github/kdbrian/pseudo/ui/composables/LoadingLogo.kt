package io.github.kdbrian.pseudo.ui.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appDark
import io.github.kdbrian.pseudo.ui.theme.appRed

@Composable
fun LoadingLogo(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(12.dp)
                .background(brush = LocalDefaultBackgroundBrush.current, shape = RoundedCornerShape(6.dp))
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(
                modifier = Modifier
                    .weight(0.40f)
                    .height(12.dp)
            )

            Spacer(
                modifier = Modifier
                    .width(4.dp)
                    .height(12.dp)
            )

            Spacer(
                modifier = Modifier
                    .weight(0.18f)
                    .height(12.dp)
                    .background(brush = LocalDefaultBackgroundBrush.current, shape = RoundedCornerShape(6.dp))
            )

            Spacer(
                modifier = Modifier
                    .width(12.dp)
                    .height(12.dp)
            )

            Spacer(
                modifier = Modifier
                    .weight(0.30f)
                    .height(12.dp)
                    .background(brush = LocalDefaultBackgroundBrush.current, shape = RoundedCornerShape(6.dp))
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(
                modifier = Modifier
                    .weight(0.40f)
                    .height(12.dp)
                    .background(brush = LocalDefaultBackgroundBrush.current, shape = RoundedCornerShape(6.dp))
            )

            Spacer(
                modifier = Modifier
                    .width(6.dp)
                    .height(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .weight(0.18f)
                    .height(12.dp)
                    .background(brush = LocalDefaultBackgroundBrush.current, shape = RoundedCornerShape(6.dp))
            )

            Spacer(
                modifier = Modifier
                    .width(12.dp)
                    .height(12.dp)
            )

            Spacer(
                modifier = Modifier
                    .weight(0.30f)
                    .height(12.dp)
                    .background(brush = LocalDefaultBackgroundBrush.current, shape = RoundedCornerShape(6.dp))
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(
                modifier = Modifier
                    .weight(0.40f)
                    .height(12.dp)
            )

            Spacer(
                modifier = Modifier
                    .weight(0.48f)
                    .height(12.dp)
                    .background(brush = LocalDefaultBackgroundBrush.current, shape = RoundedCornerShape(6.dp))
            )

            Spacer(
                modifier = Modifier
                    .width(12.dp)
                    .height(12.dp)
            )

            Spacer(
                modifier = Modifier
                    .weight(0.30f)
                    .height(12.dp)
                    .background(brush = LocalDefaultBackgroundBrush.current, shape = RoundedCornerShape(6.dp))
            )
        }
    }


}

@Composable
fun LoadingLogoShimmer(modifier: Modifier = Modifier) {
    val shimmerColors = listOf(
        appRed,
        appDark
    )

    val transition = rememberInfiniteTransition(label = "")
    val shimmerAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val shimmerBrush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(0f, 0f),
        end = Offset(shimmerAnim.value * 1000f, 0f)
    )

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .background(brush = shimmerBrush, shape = RoundedCornerShape(6.dp))
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(
                modifier = Modifier
                    .weight(0.40f)
                    .height(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(4.dp)
                    .height(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .weight(0.18f)
                    .height(12.dp)
                    .background(brush = shimmerBrush, shape = RoundedCornerShape(6.dp))
            )
            Spacer(
                modifier = Modifier
                    .width(12.dp)
                    .height(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .weight(0.30f)
                    .height(12.dp)
                    .background(brush = shimmerBrush, shape = RoundedCornerShape(6.dp))
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(
                modifier = Modifier
                    .weight(0.40f)
                    .height(12.dp)
                    .background(brush = shimmerBrush, shape = RoundedCornerShape(6.dp))
            )
            Spacer(
                modifier = Modifier
                    .width(6.dp)
                    .height(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .weight(0.18f)
                    .height(12.dp)
                    .background(brush = shimmerBrush, shape = RoundedCornerShape(6.dp))
            )
            Spacer(
                modifier = Modifier
                    .width(12.dp)
                    .height(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .weight(0.30f)
                    .height(12.dp)
                    .background(brush = shimmerBrush, shape = RoundedCornerShape(6.dp))
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(
                modifier = Modifier
                    .weight(0.40f)
                    .height(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .weight(0.48f)
                    .height(12.dp)
                    .background(brush = shimmerBrush, shape = RoundedCornerShape(6.dp))
            )
            Spacer(
                modifier = Modifier
                    .width(12.dp)
                    .height(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .weight(0.30f)
                    .height(12.dp)
                    .background(brush = shimmerBrush, shape = RoundedCornerShape(6.dp))
            )
        }
    }
}



@Preview
@Composable
private fun LoadingLogoPrev() {
    PseudoTheme {
        LoadingLogoShimmer()
    }
}


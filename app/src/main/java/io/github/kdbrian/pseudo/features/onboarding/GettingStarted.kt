package io.github.kdbrian.pseudo.features.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.ui.composables.DisplayCard
import io.github.kdbrian.pseudo.ui.composables.LoadingLogo
import io.github.kdbrian.pseudo.ui.composables.TextLogo
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GettingStarted(modifier: Modifier = Modifier) {

    val labels = listOf(
        "Seems You are new here.",
        "Pseudo notes is a platform for sharing pseudocode to other devs.",
        "Join the fun and avoid cheating."
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalDefaultBackgroundBrush.current)
    ) {

        LoadingLogo(
            modifier = Modifier.size(100.dp).align(Alignment.TopCenter).padding(vertical = 12.dp)
        )

        val state = rememberPagerState { labels.size }

        HorizontalPager(
            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
            state = state
        ) { index ->

            val label = labels[index]

            DisplayCard(
                modifier = Modifier.align(Alignment.Center),
                brush = LocalDefaultBackgroundBrush.current,
                label = label
            )
        }

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
                onClick = {},
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
private fun GettingStartedPrev(modifier: Modifier = Modifier) {
    PseudoTheme {
        GettingStarted()
    }
}



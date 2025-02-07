package io.github.kdbrian.pseudo.features.saves

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.composables.NestedRootName
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun MySaves(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalDefaultBackgroundBrush.current)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null
                )
            }

            NestedRootName(
                name = "localhost",
                modifier = Modifier.weight(1f)
            )

            Icon(
                painter = painterResource(R.drawable.baseline_book_24),
                contentDescription = null
            )

        }

    }
}

@Preview
@Composable
private fun MySavesPrev() {
    PseudoTheme {
        MySaves()
    }
}
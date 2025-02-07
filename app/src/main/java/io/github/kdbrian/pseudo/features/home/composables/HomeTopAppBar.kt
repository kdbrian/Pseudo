package io.github.kdbrian.pseudo.features.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appDark
import io.github.kdbrian.pseudo.ui.theme.greishWhite

@Composable
fun HomeTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(brush = LocalDefaultBackgroundBrush.current)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
        }

        Text(
            text = "pseudonotes.dev",
            modifier = Modifier
                .background(shape = RoundedCornerShape(16.dp), color = greishWhite)
                .padding(8.dp),
            style = LocalTextStyle.current.copy(
                color = appDark
            )
        )


        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = null)
        }

    }
}

@Preview
@Composable
private fun HomeTopAppBarPrev() {
    PseudoTheme {
        HomeTopAppBar()
    }
}
package io.github.kdbrian.pseudo.features.saves

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.composables.NestedRootName
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import kotlin.random.Random

object MySaves : Tab {

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2u,
            title = "Saves"
        )

    @Composable
    override fun Content() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalDefaultBackgroundBrush.current)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
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

            Spacer(Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Your saves",
                    style = LocalTextStyle.current.copy(
                        fontSize = 26.sp,
                    )
                )

                Spacer(Modifier.weight(1f))

                TextButton(onClick = {}) {
                    Text(
                        text = LoremIpsum(Random.nextInt(2, 5)).values.joinToString(),
                        style = LocalTextStyle.current.copy(
                            color = Color.Yellow,
                            fontSize = 12.sp
                        )
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            repeat(10) {
                SavedItemLoading()
            }
        }
    }
}

@Preview
@Composable
private fun MySavesPrev() {
    PseudoTheme {
        MySaves.Content()
    }
}
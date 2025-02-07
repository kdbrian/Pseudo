package io.github.kdbrian.pseudo.features.premium

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.ui.nav.LocalPremiumBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme


@Composable
fun PromptPremium(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalPremiumBrush.current)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Rounded.Clear,
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Premium",
                style = LocalTextStyle.current.copy(
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                ),
                modifier = Modifier
            )

            Spacer(modifier = Modifier.weight(1f))

        }


        PremiumCardLarge(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        )

        TextButton(
            onClick = {}
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Get notified",
                    style = LocalTextStyle.current.copy(
                        color = Color.White,
                        fontSize = 20.sp
                    )
                )

                Spacer(modifier = Modifier.width(21.dp))
                Switch(
                    checked = false,
                    onCheckedChange = { },
                )
            }

        }


        Text(
            text = "Get notified",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = LocalTextStyle.current.copy(
                color = Color.LightGray,
                fontSize = 18.sp
            )
        )


        Spacer(Modifier.height(12.dp))


    }
}

@Preview
@Composable
private fun PromptPremiumPrev() {
    PseudoTheme {
        PromptPremium()
    }
}
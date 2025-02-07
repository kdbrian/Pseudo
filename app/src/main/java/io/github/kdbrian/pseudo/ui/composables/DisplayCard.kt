package io.github.kdbrian.pseudo.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appDark
import io.github.kdbrian.pseudo.ui.theme.appRed
import io.github.kdbrian.pseudo.ui.theme.freckleface

@Composable
fun DisplayCard(
    modifier: Modifier = Modifier,
    brush: Brush,
    label: String = LoremIpsum(12).values.joinToString(),
) {

    Card(
        onClick = {},
        modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(brush = brush, shape = RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(),
        border = BorderStroke(width = 2.dp, color = appDark)
    ) {
        Text(
            text = label,
            modifier = Modifier
                .padding(16.dp),
            style = TextStyle(
                fontFamily = freckleface,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = appRed
            )
        )
    }


}


@Preview
@Composable
private fun DisplayCardPrev() {
    PseudoTheme {
        DisplayCard(
            brush = LocalDefaultBackgroundBrush.current,
            label = LoremIpsum(24).values.joinToString()
        )
    }
}
package io.github.kdbrian.pseudo.features.catalogue.composables

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme


@Composable
fun CategoryOnlyText(
    cat: String,
    style : TextStyle = LocalTextStyle.current.copy(color = Color.LightGray)
) {
    Text(
        text = cat,
        style = style
    )
}


@Preview
@Composable
fun CategoryOnlyTextPrev() {
    PseudoTheme {
        CategoryOnlyText(
            cat = LoremIpsum(3).values.joinToString()
        )
    }

}
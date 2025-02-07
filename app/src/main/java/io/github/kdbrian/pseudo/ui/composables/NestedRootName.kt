package io.github.kdbrian.pseudo.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.ui.theme.appDark
import io.github.kdbrian.pseudo.ui.theme.greishWhite

@Composable
fun NestedRootName(
    modifier: Modifier = Modifier,
    name: String = "pseudonotes.dev",
) {
    Text(
        text = name,
        modifier = modifier
            .background(shape = RoundedCornerShape(16.dp), color = greishWhite)
            .padding(8.dp),
        style = LocalTextStyle.current.copy(
            color = appDark,
            textAlign = TextAlign.Center
        )
    )
}

@Preview
@Composable
private fun NestedRootNamePrev() {

}
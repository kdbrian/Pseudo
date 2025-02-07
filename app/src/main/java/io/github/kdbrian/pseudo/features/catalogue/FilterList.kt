package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun FilterList(
    modifier: Modifier = Modifier,
    onFilterSelect: (String) -> Unit = {},
) {


}


@Preview
@Composable
private fun FilterListPrev() {
    PseudoTheme {
        FilterList()
    }
}
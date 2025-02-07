package io.github.kdbrian.pseudo.features.saves

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class SavedItemModel(
    val id: String = UUID.randomUUID().toString(),
)

@Composable
fun SavedItem(modifier: Modifier = Modifier) {

}


@Composable
fun SavedItemLoading(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)) {

    }
}

@Preview
@Composable
private fun SavedItemPrev() {
    PseudoTheme {
        SavedItem()
    }
}



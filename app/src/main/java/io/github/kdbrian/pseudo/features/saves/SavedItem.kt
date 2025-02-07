package io.github.kdbrian.pseudo.features.saves

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    val spacerModifier = Modifier
        .height(12.dp)
        .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp))
    
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.dp)) {

        Spacer(modifier = spacerModifier.fillMaxWidth(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Spacer(
                modifier = spacerModifier
                    .weight(0.60f)
            )
            Spacer(
                modifier = spacerModifier
                    .weight(0.20f)
            )

            Spacer(
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .weight(0.20f)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Spacer(
                modifier = spacerModifier
                    .weight(0.70f)
            )

            Spacer(Modifier.weight(0.15f))

            Spacer(
                modifier = spacerModifier
                    .weight(0.20f)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Spacer(
                modifier = spacerModifier
                    .weight(0.60f)
            )
            Spacer(
                modifier = spacerModifier
                    .weight(0.20f)
            )
        }
    }
}

@Preview
@Composable
private fun SavedItemPrev() {
    PseudoTheme {
        SavedItemLoading()
    }
}



package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class RecentItemModel(
    val string : String
)


@Composable
fun RecentItem(
    text: String = LoremIpsum(Random.nextInt(3, 6)).values.joinToString(),
    modifier: Modifier = Modifier,
    action: @Composable () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = LocalTextStyle.current.copy(
                fontSize = 14.sp
            )
        )
        Spacer(Modifier.weight(1f))
        action()
    }
}

@Composable
fun RecentItemLoading(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Spacer(
            Modifier
                .fillMaxWidth(1f)
                .height(12.dp)
                .background(color = Color.LightGray, shape = RoundedCornerShape(6.dp))
                .padding(4.dp)
        )

        Spacer(
            Modifier
                .fillMaxWidth(0.60f)
                .height(12.dp)
                .background(color = Color.LightGray, shape = RoundedCornerShape(6.dp))
                .padding(4.dp)
        )
    }
}

@Preview
@Composable
private fun RecentItemPrev() {
    PseudoTheme {
        RecentItem(
            modifier = Modifier.padding(horizontal = 6.dp),
            action = {
                TextButton (onClick = {}) {
                    Text(
                        text = "Trending",
                        style = LocalTextStyle.current.copy(
                            color = Color.Red,
                            fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic
                        )
                    )
                }
            }
        )
    }
}
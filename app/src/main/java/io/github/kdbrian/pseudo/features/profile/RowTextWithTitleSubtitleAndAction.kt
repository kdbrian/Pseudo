package io.github.kdbrian.pseudo.features.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme


@Composable
fun RowTextWithTitleSubtitleAndAction(
    modifier: Modifier = Modifier,
    title: String = LoremIpsum(5).values.joinToString(),
    titleStyle: TextStyle = LocalTextStyle.current.copy(fontSize = 24.sp, fontWeight = FontWeight.Bold),
    subTitle: String = LoremIpsum(10).values.joinToString(),
    subTitleStyle: TextStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
    actions: @Composable () -> Unit = {},
) {

    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = title, style = titleStyle)
            Text(text = subTitle, style = subTitleStyle)
        }

        actions()

    }


}


@Preview
@Composable
private fun RowTextWithTitleSubtitleAndActionPrev() {
    PseudoTheme {
        RowTextWithTitleSubtitleAndAction(
            actions = {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
            }
        )
    }
}
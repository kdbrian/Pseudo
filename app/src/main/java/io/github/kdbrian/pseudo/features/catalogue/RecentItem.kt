package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import kotlinx.serialization.Serializable

@Serializable
data class RecentItemModel(
    val string : String
)


@Composable
fun RecentItem(modifier: Modifier = Modifier) {

}

@Composable
fun RecentItemLoading(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Spacer(Modifier.fillMaxWidth(1f).height(12.dp).background(color = Color.LightGray, shape = RoundedCornerShape(6.dp)).padding(4.dp))

        Spacer(Modifier.fillMaxWidth(0.60f).height(12.dp).background(color = Color.LightGray, shape = RoundedCornerShape(6.dp)).padding(4.dp))
    }
}

@Preview
@Composable
private fun RecentItemPrev() {
    PseudoTheme {
//        RecentItem()
        RecentItemLoading()
    }
}
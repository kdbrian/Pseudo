package io.github.kdbrian.pseudo.features.groups

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.features.profile.composables.GroupItemPreview
import io.github.kdbrian.pseudo.features.profile.composables.ToolbarWithTitleSubtitleIcon
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun Groups(modifier: Modifier = Modifier) {

    val verticalScrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalDefaultBackgroundBrush.current)
            .verticalScroll(verticalScrollState)
    ) {

        ToolbarWithTitleSubtitleIcon(
            title = "Groups.",
            subTitle = "interact with member with similar interest, subscribe to receive shared content."
        )

        Spacer(Modifier.height(12.dp))


        repeat(4) {
            GroupItemPreview(modifier = Modifier.padding(horizontal = 12.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
        }


        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier.padding(6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.diversity_2),
                    contentDescription = null
                )

                Text(
                    text = "Explore",
                    style = LocalTextStyle.current
                )


            }
        }
    }

}


@Preview
@Composable
private fun GroupsPrev() {
    PseudoTheme {
        Groups()
    }
}
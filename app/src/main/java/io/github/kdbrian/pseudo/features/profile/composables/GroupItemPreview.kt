package io.github.kdbrian.pseudo.features.profile.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.features.profile.RowTextWithTitleSubtitleAndAction
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme


@Composable
fun GroupItemPreview(modifier: Modifier = Modifier) {
    RowTextWithTitleSubtitleAndAction(
        modifier = modifier,
        title = "Computer science",
        subTitle = LoremIpsum(8).values.joinToString(),
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(8.dp)
            ) {

                Box {
                    Image(
                        painter = painterResource(R.drawable.porsche),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .blur(radius = 4.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.porsche),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .offset(x = 12.dp, y = 8.dp)
                            .size(30.dp)
                            .clip(CircleShape)
                    )
                }

                Text(text = "300", style = LocalTextStyle.current)

            }
        }
    )
}

@Preview
@Composable
private fun GroupItemPreviewPrev() {
    PseudoTheme {
        GroupItemPreview()
    }
}
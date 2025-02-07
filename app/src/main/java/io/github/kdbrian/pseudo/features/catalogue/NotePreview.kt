package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.features.catalogue.composables.CategoryOnlyText
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appDangerRed
import io.github.kdbrian.pseudo.ui.theme.appGreen
import io.github.kdbrian.pseudo.ui.theme.appYellow
import io.github.kdbrian.pseudo.ui.theme.ubuntu
import java.util.Random
import java.util.UUID

@Composable
fun NotePreview(
    modifier: Modifier = Modifier,
) {

    val buggCount = kotlin.random.Random.nextInt(30,200)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "#" + UUID.randomUUID().toString().split('-').first(),
                style = LocalTextStyle.current
            )

            Spacer(Modifier.width(8.dp))

            Text(
                text = LoremIpsum(3).values.joinToString(),
                style = LocalTextStyle.current.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = if (buggCount < 50) {
                                appGreen
                            } else if (buggCount in 51..99) {
                                appYellow
                            } else
                                appDangerRed
                        )
                    ) {
                        append(buggCount.toString())
                    }
                },
                style = LocalTextStyle.current.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        val categories = listOf(
            LoremIpsum(2).values.joinToString(),
            LoremIpsum(2).values.joinToString(),
            LoremIpsum(2).values.joinToString(),
            LoremIpsum(2).values.joinToString(),
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            categories.forEachIndexed { index, cat ->
                CategoryOnlyText(
                    cat,
                    style = LocalTextStyle.current.copy(
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )
                )

                if (index == categories.size - 1) {
                    Spacer(modifier = Modifier.width(4.dp))
                } else {
                    Text(
                        text = " · ",
                        style = LocalTextStyle.current.copy(
                            fontSize = 20.sp
                        )
                    )
                }
            }
        }

        Text(
            text = LoremIpsum(24).values.joinToString(),
            style = LocalTextStyle.current.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontFamily = ubuntu
            )
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
    }

}


@Preview
@Composable
private fun NotePreviewPrev() {
    PseudoTheme {
        NotePreview()
    }
}
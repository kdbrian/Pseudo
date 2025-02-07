package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jeziellago.compose.markdowntext.MarkdownText
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appDarkGrey
import io.github.kdbrian.pseudo.ui.theme.appRed
import kotlin.random.Random

@Composable
fun ViewNote(
    modifier: Modifier = Modifier,
    banner: @Composable () -> Unit = {},
) {

    val scrollable = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalDefaultBackgroundBrush.current)
            .padding(12.dp)
            .verticalScroll(state = scrollable)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = null
                )
            }

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 16.sp
                        )
                    ) {
                        append("#")
                    }

                    withStyle(
                        SpanStyle(
                            fontSize = 20.sp
                        )
                    ) {
                        append(Random.nextInt(35, 999).toString())
                    }
                },
                style = LocalTextStyle.current
            )

        }

        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle()) {
                    append(LoremIpsum(12).values.joinToString())
                }
            },
            style = LocalTextStyle.current.copy(
                fontSize = 26.sp
            )
        )

        Spacer(Modifier.height(6.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = LoremIpsum(2).values.joinToString(),
                style = LocalTextStyle.current.copy(color = Color.LightGray)
            )

            Spacer(Modifier.width(12.dp))

            Text(
                text = LoremIpsum(2).values.joinToString(),
                style = LocalTextStyle.current.copy(color = Color.LightGray)
            )
        }

        Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxHeight(1f)
                .background(color = appDarkGrey, shape = RoundedCornerShape(12.dp))
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxHeight(1f)
                    .background(color = appDarkGrey, shape = RoundedCornerShape(12.dp))
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxHeight(1f)
                        .background(color = appDarkGrey, shape = RoundedCornerShape(12.dp))
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight(1f)
                            .offset(y = 20.dp),
                        color = appRed,
                        shape = RoundedCornerShape(12.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(6.dp)

                        ) {


                            MarkdownText(
                                markdown = """
                                    # Hello World Python Script
                                    This is a simple Python script that prints "Hello, World!" to the console.
                                    Script
                                   ```python
                                    print("Hello, World!")
                                   ```
                                   Ensure
                                   ```bash
                                    python --version
                                """.trimIndent()
                            )


                            Spacer(Modifier.weight(1f))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(
                                        shape = RoundedCornerShape(
                                            bottomStart = 12.dp,
                                            bottomEnd = 12.dp
                                        )
                                    )
                                    .padding(12.dp)
                            ) {
                                banner()
                            }
                        }


                    }
                }
            }

        }

        Spacer(Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f).alpha(0.6f),
                colors = ButtonDefaults.buttonColors(containerColor = appRed),
                shape = RoundedCornerShape(bottomStart = 12.dp, topStart = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.bug),
                        contentDescription = "runs",
                        modifier = Modifier.size(25.dp)
                    )

                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = "Bug",
                        style = LocalTextStyle.current
                    )
                }
            }


            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = appRed),
                shape = RoundedCornerShape(bottomEnd = 12.dp, topEnd = 12.dp)
            ) {

                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.athletics),
                        contentDescription = "runs",
                        modifier = Modifier.size(25.dp)
                    )

                    Spacer(Modifier.width(6.dp))

                    Text(
                        text = "Executes",
                        style = LocalTextStyle.current
                    )

                }
            }

        }


    }

}

@Preview(showSystemUi = true)
@Composable
private fun ViewNotePrev() {
    PseudoTheme {
        ViewNote(
            Modifier.systemBarsPadding()
        )
    }
}
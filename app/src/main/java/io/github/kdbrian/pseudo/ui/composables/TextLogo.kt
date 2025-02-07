package io.github.kdbrian.pseudo.ui.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalFontFamily
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appDark
import io.github.kdbrian.pseudo.ui.theme.appRed


@Composable
fun TextLogo(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    brush = LocalDefaultBackgroundBrush.current,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = LocalFontFamily.current
                )
            ) {
                append("Pseudo\n")
            }

            withStyle(
                SpanStyle(
                    brush = LocalDefaultBackgroundBrush.current,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = LocalFontFamily.current,
                    fontSize = 48.sp
                )
            ) {
                append("Notes\n")
            }
        },
        lineHeight = 40.sp
    )

}


@Preview
@Composable
private fun TextLogoPrev() {
    PseudoTheme {
        CompositionLocalProvider(
            LocalDefaultBackgroundBrush provides Brush.verticalGradient(listOf(appRed, appDark))
        ) {
            TextLogo()
        }
    }
}
package io.github.kdbrian.pseudo.ui.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appBlue
import io.github.kdbrian.pseudo.ui.theme.appDark
import io.github.kdbrian.pseudo.ui.theme.appRed
import io.github.kdbrian.pseudo.ui.theme.freckleface
import io.github.kdbrian.pseudo.ui.theme.fredoka

val RedDarkBackgroundBrush = Brush.verticalGradient(
    colors = listOf(appRed, appDark),
)

val PremiumColorsBrush = Brush.verticalGradient(
    colors = listOf(appRed, appBlue)
)

val LocalPremiumBrush = staticCompositionLocalOf {
    PremiumColorsBrush
}

val LocalDefaultBackgroundBrush = staticCompositionLocalOf {
    Brush.verticalGradient(colors = listOf(Color.White, Color.Black))
}

val LocalFontFamily = staticCompositionLocalOf {
    fredoka
}

val LocalTextStyle = staticCompositionLocalOf {
    TextStyle(
        fontSize = 16.sp,
        fontFamily = fredoka
    )
}

@Composable
fun App(
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(
        LocalDefaultBackgroundBrush provides RedDarkBackgroundBrush,
        LocalFontFamily provides fredoka,
        LocalTextStyle provides TextStyle(),
        LocalPremiumBrush provides PremiumColorsBrush
    ) {


    }

}


@Preview
@Composable
private fun AppPrev() {
    PseudoTheme {
        App()
    }
}
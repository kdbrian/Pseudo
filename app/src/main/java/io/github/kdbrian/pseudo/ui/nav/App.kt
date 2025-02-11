package io.github.kdbrian.pseudo.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import io.github.kdbrian.pseudo.features.onboarding.OnBoardingScreen
import io.github.kdbrian.pseudo.features.onboarding.Splash
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appBlue
import io.github.kdbrian.pseudo.ui.theme.appDark
import io.github.kdbrian.pseudo.ui.theme.appRed
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
        fontSize = 20.sp,
        fontFamily = fredoka
    )
}

@Composable
fun App() {
    CompositionLocalProvider(
        LocalDefaultBackgroundBrush provides RedDarkBackgroundBrush,
        LocalFontFamily provides fredoka,
        LocalTextStyle provides TextStyle(),
        LocalPremiumBrush provides PremiumColorsBrush
    ) {
        Navigator(Splash)
    }

}


@Preview
@Composable
private fun AppPrev() {
    PseudoTheme {
        App()
    }
}
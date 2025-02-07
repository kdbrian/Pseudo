package io.github.kdbrian.pseudo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.R

val fredoka by lazy {
    FontFamily(
        Font(resId = R.font.fredokabold, style = FontStyle.Normal),
        Font(resId = R.font.fredokacondensedbold, style = FontStyle.Normal),
        Font(resId = R.font.fredokacondensedlight, style = FontStyle.Normal),
        Font(resId = R.font.fredokacondensedmedium, style = FontStyle.Normal),
        Font(resId = R.font.fredokacondensedregular, style = FontStyle.Normal),
        Font(resId = R.font.fredokacondensedsemibold, style = FontStyle.Normal),
        Font(resId = R.font.fredokaexpandedbold, style = FontStyle.Normal),
        Font(resId = R.font.fredokaexpandedlight, style = FontStyle.Normal),
        Font(resId = R.font.fredokaexpandedmedium, style = FontStyle.Normal),
        Font(resId = R.font.fredokaexpandedregular, style = FontStyle.Normal),
        Font(resId = R.font.fredokaexpandedsemibold, style = FontStyle.Normal),
        Font(resId = R.font.fredokalight, style = FontStyle.Normal),
        Font(resId = R.font.fredokamedium, style = FontStyle.Normal),
        Font(resId = R.font.fredokaregular, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemibold, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemicondensedbold, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemicondensedmedium, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemicondensedlight, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemicondensedregular, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemicondensedsemibold, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemiexpandedbold, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemiexpandedlight, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemiexpandedmedium, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemiexpandedregular, style = FontStyle.Normal),
        Font(resId = R.font.fredokasemiexpandedsemibold, style = FontStyle.Normal),
    )
}
val freckleface by lazy {
    FontFamily(
        Font(resId = R.font.frecklefaceregular, style = FontStyle.Normal)
    )
}


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
package io.github.kdbrian.pseudo.features.premium

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.nav.LocalPremiumBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appBlue
import io.github.kdbrian.pseudo.ui.theme.appRed


@Composable
fun PremiumCardLarge(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .background(
                brush = LocalPremiumBrush.current,
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp,
                    bottomEnd = 32.dp,
                    bottomStart = 0.dp,
                )
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {


            Icon(
                imageVector = Icons.Rounded.Lock,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(24.dp),
                tint = appBlue
            )

            Text(
                text = "Coming soon",
                style = LocalTextStyle.current.copy(fontSize = 48.sp, color = Color.White),
                modifier = Modifier.align(Alignment.Center)
            )

            Icon(
                painter = painterResource(R.drawable.round_verified_user_24),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(24.dp),
                tint = appRed
            )
        }
    }

}

@Preview
@Composable
private fun PremiumCardLargePrev() {
    PseudoTheme {
        PremiumCardLarge(Modifier.padding(6.dp))
    }
}
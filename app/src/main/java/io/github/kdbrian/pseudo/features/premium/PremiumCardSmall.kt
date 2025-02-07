package io.github.kdbrian.pseudo.features.premium

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appBlue
import io.github.kdbrian.pseudo.ui.theme.appRed

@Composable
fun PremiumCardSmall(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        appRed,
                        appBlue
                    )
                ),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp,
                    bottomEnd = 32.dp,
                    bottomStart = 0.dp,
                )
            )
            .fillMaxWidth()
            .height(180.dp)
    ) {

        Icon(
            imageVector = Icons.Rounded.Lock,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(24.dp)
        )


        Icon(
            painter = painterResource(R.drawable.round_verified_user_24),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        )

    }
}

@Preview
@Composable
private fun PremiumCardSmallPrev() {
    PseudoTheme {
        PremiumCardSmall()
    }
}
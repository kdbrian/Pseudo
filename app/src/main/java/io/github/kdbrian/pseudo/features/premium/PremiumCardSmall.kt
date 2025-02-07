package io.github.kdbrian.pseudo.features.premium

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appBlue
import io.github.kdbrian.pseudo.ui.theme.appRed

@Composable
fun PremiumCardSmall(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
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
            .height(180.dp),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize().padding(6.dp)) {

            val (lock, verif, title, subtitle) = createRefs()

            Icon(
                imageVector = Icons.Rounded.Lock,
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(lock) {
                        top.linkTo(parent.top, 12.dp)
                        start.linkTo(parent.start, 12.dp)
                    }
            )

            Text(
                text = "Premium",
                style = LocalTextStyle.current.copy(fontSize = 32.sp, color = Color.White),
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(lock.bottom)
                }
            )



            Text(
                text = "Coming soon",
                style = LocalTextStyle.current.copy(fontSize = 48.sp, color = Color.White),
                modifier = Modifier.constrainAs(subtitle) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(title.bottom)
                }
            )

            Icon(
                painter = painterResource(R.drawable.round_verified_user_24),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(verif) {
                        top.linkTo(subtitle.bottom, 12.dp)
                        bottom.linkTo(parent.bottom, 12.dp)
                        end.linkTo(parent.end, 24.dp)
                    }
            )
        }
    }
}

@Preview
@Composable
private fun PremiumCardSmallPrev() {
    PseudoTheme {
        PremiumCardSmall(Modifier.padding(8.dp))
    }
}
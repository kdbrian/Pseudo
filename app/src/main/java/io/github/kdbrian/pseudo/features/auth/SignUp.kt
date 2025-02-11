package io.github.kdbrian.pseudo.features.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.features.home.HomeScreen
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appRed
import io.github.kdbrian.pseudo.ui.theme.freckleface

class SignUp : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = LocalDefaultBackgroundBrush.current)
        ) {

            val (
                closeBtn,
                loginBtn,
                tAndCBtn,
                title, subTitle,
            ) = createRefs()

            IconButton(
                onClick = { navigator.pop() }, modifier = Modifier
                    .constrainAs(closeBtn) {
                        top.linkTo(parent.top, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(vertical = 12.dp)
            ) {
                Icon(
                    imageVector =
                    Icons.Rounded.Clear,
                    contentDescription = null
                )
            }


            Text(
                text = "Join us",
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(closeBtn.bottom, margin = 72.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                style = LocalTextStyle.current.copy(fontSize = 32.sp)
            )


            Text(
                text = "As of now the only\n" +
                        "supported method is GitHub login ",
                modifier = Modifier.constrainAs(subTitle) {
                    top.linkTo(title.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                style = LocalTextStyle.current.copy(
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light
                )
            )

            Button(
                onClick = {
                    navigator.push(HomeScreen)
                },
                modifier = Modifier
                    .constrainAs(loginBtn) {
                        top.linkTo(subTitle.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(tAndCBtn.top)
                    }
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = appRed,
                    contentColor = Color.White
                )
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(R.drawable.ghublogo),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )

                    Spacer(Modifier.width(6.dp))

                    Text(
                        text = "Github Login",
                        style = LocalTextStyle.current
                    )

                }


            }


            TextButton(
                onClick = {},
                modifier = Modifier
                    .constrainAs(tAndCBtn) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(vertical = 12.dp)
            ) {
                Text(
                    text = "Terms and  conditions apply.",
                    style = LocalTextStyle.current.copy(fontFamily = freckleface, color = appRed),
                )
            }


        }
    }
}
@Composable
fun SignUp(
    modifier: Modifier = Modifier,
    onClose: () -> Unit = {},
) {

}

@Preview
@Composable
private fun SignUpPrev() {
    PseudoTheme {
        SignUp()
    }
}
package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {

    val (query, setQuery) = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalDefaultBackgroundBrush.current)
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            /*
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = null
                )
            }

             */

//            Spacer(Modifier.width(12.dp))

            Text(
                text = "Search",
                style = LocalTextStyle.current.copy(
                    fontSize = 48.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )


            Image(
                painter = painterResource(R.drawable.search),
                modifier = Modifier.size(30.dp),
                contentDescription = null
            )

        }


        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = query,
            onValueChange = setQuery,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            placeholder = {
                Text(
                    text = "type here",
                    style = LocalTextStyle.current.copy(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                )
            }
        )

        Spacer(Modifier.height(32.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Recents",
                style = LocalTextStyle.current.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )


            Image(
                painter = painterResource(R.drawable.clear),
                modifier = Modifier.size(30.dp),
                contentDescription = null
            )

        }
    }

}


@Preview
@Composable
private fun SearchScreenPrev() {
    PseudoTheme {
        SearchScreen()
    }
}


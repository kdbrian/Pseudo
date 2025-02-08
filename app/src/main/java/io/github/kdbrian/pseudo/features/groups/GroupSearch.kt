package io.github.kdbrian.pseudo.features.groups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.features.profile.composables.GroupItemPreview
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appRed
import io.github.kdbrian.pseudo.ui.theme.ubuntu
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupSearch(modifier: Modifier = Modifier) {

    val (query, setQuery) = remember { mutableStateOf("") }
    var showFilters by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(brush = LocalDefaultBackgroundBrush.current)
                .padding(horizontal = 12.dp)
        ) {

            Spacer(Modifier.height(30.dp))

            Surface(
                shadowElevation = 12.dp,
                shape = RoundedCornerShape(32.dp),
                color = Color.Transparent,
//                modifier = Modifier.background(brush = LocalPremiumBrush.current)
            ) {
                TextField(
                    value = query,
                    onValueChange = setQuery,
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = { showFilters = !showFilters }) {
                            Icon(
                                painter = painterResource(R.drawable.filter_list),
                                contentDescription = null
                            )
                        }
                    },
                    placeholder = {
                        Text(
                            text = "type here",
                            style = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Center,
                                fontFamily = ubuntu
                            ),

                            )
                    },
                    textStyle = LocalTextStyle.current.copy(fontFamily = ubuntu, fontSize = 18.sp),
                    shape = RoundedCornerShape(32.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedContainerColor = appRed
                    )
                )
            }

            Spacer(Modifier.height(24.dp))

            repeat(4) {
                GroupItemPreview()
            }

            if (showFilters) {
                val sheetState = rememberModalBottomSheetState()
                val scope = rememberCoroutineScope()

                ModalBottomSheet(onDismissRequest = {

                    scope.launch {
                        sheetState.hide()
                        showFilters = !showFilters
                    }
                }) {


                }
            }
        }
    }


}

@Preview
@Composable
private fun GroupSearchPrev() {
    PseudoTheme {
        GroupSearch()
    }
}
package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(modifier: Modifier = Modifier) {

    val (query, setQuery) = remember { mutableStateOf("") }
    var selectedTopic by remember { mutableIntStateOf(0) }
    var showFilters by remember { mutableStateOf(false) }

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
                    modifier = Modifier.fillMaxWidth(),
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

        Spacer(Modifier.height(12.dp))

        Column {
            repeat(6) {
                Text(
                    text = LoremIpsum(Random.nextInt(6)).values.joinToString(),
                    style = LocalTextStyle.current.copy(
                        color = Color.LightGray,
                        fontSize = 14.sp
                    )
                )

                Spacer(Modifier.height(7.dp))
            }
        }


        Spacer(Modifier.height(32.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Topics",
                style = LocalTextStyle.current.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            TextButton(onClick = {
                showFilters = !showFilters
            }) {
                Text(
                    text = "More",
                    style = LocalTextStyle.current.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Blue
                    )
                )
            }


        }

        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Fixed(3)
        ) {
            items(count = 10) {
                FilterChip(
                    selected = selectedTopic == it,
                    onClick = { selectedTopic = it },
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {

                            AnimatedVisibility(selectedTopic == it) {
                                Icon(
                                    imageVector = Icons.Rounded.Check,
                                    contentDescription = null
                                )
                            }

                            Text(
                                text = LoremIpsum(Random.nextInt(4)).values.joinToString(),
                                style = LocalTextStyle.current.copy(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Light
                                )
                            )
                        }
                    }
                )
            }
        }

        if (showFilters) {
            val sheetState = rememberModalBottomSheetState()
            val scope = rememberCoroutineScope()

            ModalBottomSheet(
                onDismissRequest = {
                    scope.launch {
                        sheetState.hide()
                        showFilters = !showFilters
                    }
                }
            ) {
                FilterList(onFilterSelect = {})
            }
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


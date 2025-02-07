package io.github.kdbrian.pseudo.features.topics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.features.catalogue.NotePreview
import io.github.kdbrian.pseudo.ui.composables.NestedRootName
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appRed


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerTopicFeedScreen(modifier: Modifier = Modifier) {

    var showTopics by remember { mutableStateOf(false) }
    val demoTopics = listOf(
        "t/sorting_algorithms",
        "t/graph_traversal",
        "t/fibonacci_sequence",
        "t/dijkstra_shortest_path",
        "t/string_matching_algorithms",
        "t/knapsack_problem",
        "t/binary_search",
        "t/prime_number_testing",
        "t/tower_of_hanoi",
        "t/recursive_factorial"
    )
    val verticalScrollState = rememberScrollState()
    val (selectedTopic, setSelectedTopic) = remember { mutableStateOf("t/helloworld") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box(contentAlignment = Alignment.Center) {

                        NestedRootName(
                            name = selectedTopic,
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = appRed,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .clickable { showTopics = !showTopics }
                        )

                        DropdownMenu(
                            modifier = Modifier,
                            expanded = showTopics,
                            onDismissRequest = { showTopics = !showTopics }
                        ) {

                            demoTopics.forEachIndexed { index, topic ->
                                DropdownMenuItem(
                                    modifier = Modifier.wrapContentWidth(),
                                    text = {
                                        Text(
                                            text = topic,
                                            style = LocalTextStyle.current.copy(
                                                textAlign = TextAlign.Center
                                            )
                                        )
                                    },
                                    onClick = {
                                        setSelectedTopic(demoTopics[index])
                                        showTopics = !showTopics
                                    }
                                )
                            }

                            Spacer(Modifier.height(8.dp))

                            TextButton(onClick = {}) {
                                Text(text = "More +", style = LocalTextStyle.current)
                            }

                        }
                    }
                },
                actions = {
                    TextButton(onClick = {}) {
                        Text(
                            text = LoremIpsum(2).values.joinToString(),
                            style = LocalTextStyle.current.copy(
                                color = Color.LightGray,
                                fontSize = 14.sp
                            )
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = appRed,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        modifier = modifier.background(brush = LocalDefaultBackgroundBrush.current),
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(verticalScrollState)
                .background(brush = LocalDefaultBackgroundBrush.current)
                .padding(12.dp)
        ) {
            repeat(20) {
                NotePreview()
            }
        }
    }


}


@Preview
@Composable
private fun PerTopicFeedScreenPrev() {
    PseudoTheme {
        PerTopicFeedScreen()
    }
}
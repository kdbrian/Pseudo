package io.github.kdbrian.pseudo.features.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.features.profile.composables.ToolbarWithTitleSubtitleIcon
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalPremiumBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun ListSettings(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalDefaultBackgroundBrush.current)
    ) {
        var isGroupedByExpanded by remember { mutableStateOf(true) }
        //todo : save in data store
        var selectedGroupOption by remember { mutableIntStateOf(0) }
        val groupOptions = listOf(
            "Don't Group",
            "Name",
            "Date Added",
            "Buggyness"
        )

        ToolbarWithTitleSubtitleIcon(
            title = "Lists",
            subTitle = "A cool way to customize your saves",
        )

        Spacer(Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .clickable { isGroupedByExpanded = !isGroupedByExpanded }
        ) {

            Text(
                text = "Group By",
                style = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
//                    brush = LocalPremiumBrush.current,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(Modifier.weight(1f))


            Icon(
                imageVector = if (isGroupedByExpanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
                contentDescription = null
            )
        }

        Spacer(Modifier.height(8.dp))

        androidx.compose.animation.AnimatedVisibility(isGroupedByExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                groupOptions.forEachIndexed { index, option ->
                    Row(
                        modifier = Modifier
                            .padding(6.dp)
                            .fillMaxWidth()
                            .clickable { selectedGroupOption = index },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = option,
                            style = LocalTextStyle.current.copy(
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        AnimatedVisibility(selectedGroupOption == index) {
                            Icon(
                                imageVector = Icons.Rounded.Check,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }

    }

}

@Preview
@Composable
private fun ListSettingsPrev() {
    PseudoTheme {
        ListSettings()
    }
}
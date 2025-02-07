package io.github.kdbrian.pseudo.features.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.kdbrian.pseudo.features.profile.composables.ToolbarWithTitleSubtitleIcon
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun Groups(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        ToolbarWithTitleSubtitleIcon(
            title = "Notification settings.",
            subTitle = "join others for a personalized experience"
        )


    }

}


@Preview
@Composable
private fun GroupsPrev() {
    PseudoTheme {
        Groups()
    }
}
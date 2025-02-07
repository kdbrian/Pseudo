package io.github.kdbrian.pseudo.features.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

@Composable
fun NotificationSettings(modifier: Modifier = Modifier) {

    //use prefs
    var newContentNotifications by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = LocalDefaultBackgroundBrush.current)
    ) {



        ToolbarWithTitleSubtitleIcon(
            title = "Notification settings.",
            subTitle = "join others for a personalized experience"
        )

        Spacer(Modifier.height(12.dp))

        RowTextWithTitleSubtitleAndAction(
            title = "New Posts",
            subTitle = "Get notified when there is new content to consume",
            actions = {
                Switch(
                    checked = newContentNotifications,
                    onCheckedChange = { newContentNotifications = it }
                )
            },
            modifier = Modifier
                .padding(horizontal = 12.dp)
        )

    }
}

@Preview
@Composable
private fun NotificationSettingsPrev() {
    PseudoTheme {
        NotificationSettings()
    }
}
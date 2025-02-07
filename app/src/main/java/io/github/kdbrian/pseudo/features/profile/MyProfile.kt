package io.github.kdbrian.pseudo.features.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.pseudo.BuildConfig
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.features.premium.PremiumCardSmall
import io.github.kdbrian.pseudo.ui.nav.LocalDefaultBackgroundBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme
import io.github.kdbrian.pseudo.ui.theme.appGreen
import io.github.kdbrian.pseudo.ui.theme.appRed
import io.github.kdbrian.pseudo.ui.theme.ubuntu


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfile(modifier: Modifier = Modifier) {

    var showAccountSettings by remember { mutableStateOf(true) }

    CompositionLocalProvider(
        LocalTextStyle provides LocalTextStyle.current.copy(
            fontFamily = ubuntu,
            fontSize = 18.sp
        )
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    modifier = Modifier.padding(12.dp),
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(R.drawable.porsche),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(Modifier.width(6.dp))

                            Text(
                                text = LoremIpsum(3).values.joinToString(),
                                style = LocalTextStyle.current.copy(
                                    fontFamily = ubuntu,
                                    fontWeight = FontWeight.Light,
                                )
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                contentDescription = null
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = null)
                        }
                    }
                )
            },
            modifier = modifier
                .fillMaxSize()
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(brush = LocalDefaultBackgroundBrush.current)
                    .padding(12.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showAccountSettings = !showAccountSettings },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Account",
                        style = LocalTextStyle.current.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )


                    Icon(
                        imageVector = if (showAccountSettings) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
                        contentDescription = null
                    )

                }


                AnimatedVisibility(
                    visible = showAccountSettings,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    label = "TODO()"
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Repositories",
                                style = LocalTextStyle.current
                            )

                            Text(
                                text = "300",
                                style = LocalTextStyle.current.copy(
                                    fontWeight = FontWeight.Light,
                                    fontSize = 14.sp,
                                    color = appGreen
                                )
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Gists",
                                style = LocalTextStyle.current
                            )

                            Text(
                                text = "300",
                                style = LocalTextStyle.current.copy(
                                    fontWeight = FontWeight.Light,
                                    fontSize = 14.sp,
                                    color = appGreen
                                )
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Followers",
                                style = LocalTextStyle.current
                            )

                            Text(
                                text = "300",
                                style = LocalTextStyle.current.copy(
                                    fontWeight = FontWeight.Light,
                                    fontSize = 14.sp,
                                    color = appGreen
                                )
                            )
                        }
                    }


                }


                Spacer(Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Preferences",
                        style = LocalTextStyle.current.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                Column(
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {

                    Spacer(Modifier.height(12.dp))
                    RowTextWithTitleSubtitleAndAction(
                        title = "Notification Settings.",
                        subTitle = "Customize your notification experience",
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Rounded.Notifications,
                                    contentDescription = null
                                )
                            }
                        }
                    )


                    Spacer(Modifier.height(12.dp))
                    RowTextWithTitleSubtitleAndAction(
                        title = "Lists and organizing.",
                        subTitle = "Your saves customized",
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Rounded.Notifications,
                                    contentDescription = null
                                )
                            }
                        }
                    )

                    Spacer(Modifier.height(12.dp))
                    RowTextWithTitleSubtitleAndAction(
                        title = "Topics.",
                        subTitle = "Your topics customized",
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Rounded.Notifications,
                                    contentDescription = null
                                )
                            }
                        }
                    )


                    Spacer(Modifier.height(12.dp))
                    RowTextWithTitleSubtitleAndAction(
                        title = "Groups.",
                        subTitle = "Customize your notification experience",
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(R.drawable.diversity_2),
                                    contentDescription = null
                                )
                            }
                        }
                    )

                    Spacer(Modifier.height(12.dp))
                    TextButton(onClick = {}) {

                        Text(
                            text = "Delete Account",
                            style = LocalTextStyle.current.copy(
                                color = appRed,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    PremiumCardSmall()
                    Spacer(Modifier.weight(1f))

                    Text(
                        text = "build ${BuildConfig.VERSION_NAME}",
                        style = LocalTextStyle.current.copy(
                            color = Color.LightGray,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )


                    Spacer(Modifier.weight(1f))

                }


            }
        }
    }


}


@Preview
@Composable
private fun MyProfilePrev() {
    PseudoTheme {
        MyProfile()
    }
}



package io.github.kdbrian.pseudo.features.catalogue.composables

import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import io.github.kdbrian.pseudo.R
import io.github.kdbrian.pseudo.features.catalogue.util.TextButtonFormatterAction


//@Serializable
sealed class TextFormatterButtonModel(
    val icon: Any? = null,
    val title: String,
    action: TextButtonFormatterAction,
    var isActive: Boolean = false,
) {

    data object BoldFormat : TextFormatterButtonModel(
        title = "bold",
        action = TextButtonFormatterAction.Bold,
        icon = R.drawable.baseline_format_bold_24
    )

    data object ItalicFormat : TextFormatterButtonModel(
        title = "italic",
        action = TextButtonFormatterAction.Italic,
        icon = R.drawable.format_italic
    )

    data object ListFormat : TextFormatterButtonModel(
        title = "list",
        action = TextButtonFormatterAction.FormatList,
        icon = R.drawable.list
    )

    data object TabFormat : TextFormatterButtonModel(
        title = "tab",
        action = TextButtonFormatterAction.Tab,
        icon = R.drawable.keyboard_tab
    )

    data object CodeFormat : TextFormatterButtonModel(
        title = "code",
        action = TextButtonFormatterAction.Code,
        icon = R.drawable.code
    )

    data object OrderListNumbered : TextFormatterButtonModel(
        title = "OrderListNumbered",
        action = TextButtonFormatterAction.Tab,
        icon = R.drawable.round_format_list_numbered_24
    )

    companion object {
        //        fun invoke(){}
        val formatters = listOf(CodeFormat, BoldFormat, ItalicFormat, ListFormat, TabFormat, OrderListNumbered)
    }
}


@Composable
fun TextFormatterButton(
    modifier: Modifier = Modifier,
    formatterButton: TextFormatterButtonModel,
    onCheckedChange: (TextFormatterButtonModel) -> Unit = {},
) {
    IconToggleButton(
        modifier = modifier,
        checked = formatterButton.isActive,
        onCheckedChange = {
            formatterButton.isActive = !formatterButton.isActive
            onCheckedChange(formatterButton)
            //todo : done somewhere else
        },
    ) {
        when (formatterButton.icon) {
            is Int -> {
                Image(
                    painter = painterResource(formatterButton.icon),
                    contentDescription = null
                )
            }

            is ImageVector -> {
                Image(
                    imageVector = formatterButton.icon,
                    contentDescription = null
                )
            }

            else -> {
                Icon(
                    painter = painterResource(R.drawable.priority_high),
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        }
    }


}
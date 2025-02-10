package io.github.kdbrian.pseudo

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.skydoves.colorpicker.compose.AlphaSlider
import com.github.skydoves.colorpicker.compose.ColorEnvelope
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import io.github.kdbrian.pseudo.ui.nav.LocalPremiumBrush
import io.github.kdbrian.pseudo.ui.nav.LocalTextStyle
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme


@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun ColorPicker(
    modifier: Modifier = Modifier,
) {


    val controller = rememberColorPickerController()

    Column(modifier = Modifier.fillMaxSize()) {
        HsvColorPicker(
            modifier = modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(10.dp),
            controller = controller,
            onColorChanged = { colorEnvelope: ColorEnvelope ->
                // do something
                val color: Color = colorEnvelope.color // ARGB color value.
                val hexCode: String =
                    colorEnvelope.hexCode // Color hex code, which represents color value.
                val fromUser: Boolean =
                    colorEnvelope.fromUser // Represents this event is triggered by user or not.
            }
        )

        Spacer(Modifier.height(32.dp))

        AlphaSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(35.dp),
            controller = controller,
        )

        AnimatedContent(
            targetState = controller.selectedColor, label = "",
        ) { color ->
            if (color.value == Color.White) {
                Text(
                    text = "Hello",
                    color = controller.selectedColor.value,
                    style = LocalTextStyle.current.copy(
                        brush = LocalPremiumBrush.current,
                        fontSize = 72.sp
                    )
                )
            } else {

                Text(
                    text = "Hello ${controller.selectedColor.value}",
                    fontSize = 72.sp,
                    style = LocalTextStyle.current.copy(color = controller.selectedColor.value, fontSize = 48.sp)
                )
            }
        }


    }


}


@Preview
@Composable
private fun ColorPickerPrev() {
    PseudoTheme {
        ColorPicker()
    }
}



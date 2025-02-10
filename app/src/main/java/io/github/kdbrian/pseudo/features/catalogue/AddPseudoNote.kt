package io.github.kdbrian.pseudo.features.catalogue

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import io.github.kdbrian.pseudo.features.catalogue.composables.TextFormatterButton
import io.github.kdbrian.pseudo.features.catalogue.composables.TextFormatterButtonModel
import io.github.kdbrian.pseudo.ui.theme.PseudoTheme

//class AddPseudoNoteScreen : Screen


@Composable
fun AddPseudoNote(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {

        val editorState = rememberRichTextState()
        val horizontalScroll = rememberScrollState()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(horizontalScroll)
                .padding(12.dp)
        ) {
            TextFormatterButtonModel.formatters.forEach { textFormatterButtonModel ->
                TextFormatterButton(
                    formatterButton = textFormatterButtonModel
                ) { action ->
                    when (action) {
                        TextFormatterButtonModel.BoldFormat -> {
                            if (textFormatterButtonModel.isActive) {
                                editorState.toggleSpanStyle(SpanStyle(fontWeight = FontWeight.Bold))
                            } else {
                                editorState.toggleSpanStyle(SpanStyle(fontWeight = FontWeight.Normal))
                            }
                        }

                        TextFormatterButtonModel.ItalicFormat -> {
                            if (textFormatterButtonModel.isActive) {
                                editorState.toggleSpanStyle(SpanStyle(fontStyle = FontStyle.Italic))
                            } else {
                                editorState.toggleSpanStyle(SpanStyle(fontStyle = FontStyle.Normal))
                            }
                        }

                        TextFormatterButtonModel.ListFormat -> {
                            if (textFormatterButtonModel.isActive) {
                                editorState.toggleUnorderedList()
                            }
                        }

                        TextFormatterButtonModel.TabFormat -> {
                            if (textFormatterButtonModel.isActive) {
                                editorState.toggleParagraphStyle(
                                    ParagraphStyle(
                                        textIndent = TextIndent(restLine = 4.sp)
                                    )
                                )
                            }
                        }

                        TextFormatterButtonModel.CodeFormat -> {
                            if (textFormatterButtonModel.isActive) {
                                editorState.toggleCodeSpan()
                                println(editorState.isCodeSpan)
                            }
                        }

                        TextFormatterButtonModel.OrderListNumbered -> {
                            if (textFormatterButtonModel.isActive) {
                                editorState.toggleOrderedList()
                                println(editorState.isCodeSpan)

                            }
                        }
                    }
                }
            }
        }

        RichTextEditor(
            state = editorState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            supportingText = { Text("fun") },
        )
    }
}

@Preview
@Composable
private fun AddPseudoNotePrev() {
    PseudoTheme {
        AddPseudoNote()
    }
}


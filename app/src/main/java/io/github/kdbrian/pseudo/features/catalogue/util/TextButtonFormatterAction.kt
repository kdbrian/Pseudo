package io.github.kdbrian.pseudo.features.catalogue.util

sealed interface TextButtonFormatterAction {
    data object Bold : TextButtonFormatterAction
    data object Italic : TextButtonFormatterAction
    data object FormatList : TextButtonFormatterAction
    data object Tab : TextButtonFormatterAction
    data object Code : TextButtonFormatterAction
}

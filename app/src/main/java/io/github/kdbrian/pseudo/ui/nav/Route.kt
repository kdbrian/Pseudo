package io.github.kdbrian.pseudo.ui.nav

import kotlinx.serialization.Serializable

@Serializable
sealed class Route {

    @Serializable
    data object Home : Route()

    @Serializable
    data class ViewNote(val noteId : String) : Route()

    @Serializable
    data object Saves : Route()

    @Serializable
    data object Search : Route()

    @Serializable
    data class SearchResults(val query : String): Route()

    @Serializable
    data object Trending : Route()

    @Serializable
    data object MyFeed : Route()

    @Serializable
    data object Profile : Route()

    @Serializable
    data object ExplorePremium : Route()

    @Serializable
    data object NotificationSettings : Route()

    @Serializable
    data object Groups : Route()

}

package com.darklabs.jokepack.ui.state

import androidx.compose.Model

@Model
object AppState {
    var currentScreen: Screen = Screen.Categories
}

sealed class Screen {
    object Categories : Screen()
    data class Joke(val category: String) : Screen()
}

fun navigateTo(destination: Screen) {
    AppState.currentScreen = destination
}
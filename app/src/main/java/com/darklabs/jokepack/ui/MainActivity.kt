package com.darklabs.jokepack.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.animation.Crossfade
import androidx.ui.core.setContent
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.material.MaterialTheme
import com.darklabs.jokepack.ui.screen.category.CategoryScreen
import com.darklabs.jokepack.ui.screen.category.CategoryViewModel
import com.darklabs.jokepack.ui.screen.joke.JokeScreen
import com.darklabs.jokepack.ui.state.AppState
import com.darklabs.jokepack.ui.state.Screen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: CategoryViewModel by viewModel()

        viewModel.getJokeCategories()

        setContent {
            AppContent(viewModel)
        }
    }
}

@Composable
fun AppContent(viewModel: CategoryViewModel) {
    val colorPalette = if (isSystemInDarkTheme()) {
        darkThemeColors
    } else {
        lightThemeColors
    }

    MaterialTheme(colors = colorPalette) {
        Crossfade(current = AppState.currentScreen) { screen ->
            when (screen) {
                is Screen.Categories -> CategoryScreen(viewModel)
                is Screen.Joke -> JokeScreen()
            }
        }
    }
}
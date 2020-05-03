package com.darklabs.jokepack.ui.screen.joke

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.material.Scaffold
import com.darklabs.jokepack.data.observe
import com.darklabs.jokepack.ui.MainViewModel
import com.darklabs.network.Joke


@Composable
fun JokeScreen(viewModel: MainViewModel, category: String) {

    viewModel.getJokeForCategory(category)
    Scaffold(
        bodyContent = { JokeContent(observe(data = viewModel.joke)) }
    )
}

@Composable
fun JokeContent(joke: Joke?) {
    joke?.let { Text(text = it.value) }
}

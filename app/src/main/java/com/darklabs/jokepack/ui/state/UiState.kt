package com.darklabs.jokepack.ui.state

import androidx.compose.Composable
import androidx.compose.onActive
import androidx.compose.state
import androidx.compose.getValue
import androidx.compose.setValue
import com.darklabs.jokepack.data.Result

typealias RepositoryCall<T> = ((Result<T>) -> Unit) -> Unit

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val exception: Exception) : UiState<Nothing>()
}

@Composable
fun <T> uiStateFrom(repositoryCall: RepositoryCall<T>): UiState<T> {
    var state: UiState<T> by state<UiState<T>> { UiState.Loading }

    onActive {
        repositoryCall { result ->
            state = when (result) {
                is Result.Success -> UiState.Success(result.data)
                is Result.Error -> UiState.Error(result.exception)
            }
        }
    }

    return state
}
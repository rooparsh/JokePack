package com.darklabs.jokepack.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.darklabs.jokepack.data.repository.joke.CategoryRepository
import com.darklabs.network.Joke
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repository: CategoryRepository) : ViewModel() {

    private val _jokeCategories = MutableLiveData<List<String>>()
    private val _joke = MutableLiveData<Joke>()
    val jokeCategories: LiveData<List<String>> = _jokeCategories
    val joke: LiveData<Joke> = _joke

    fun getJokeCategories() {
        GlobalScope.launch {
            try {
                _jokeCategories.postValue(repository.getJokeCategories())

            } catch (e: Exception) {
                Log.e("ERROR>>JOKE_Categories", e.localizedMessage!!)
            }
        }
    }

    fun getJokeForCategory(category: String) {
        GlobalScope.launch {
            try {
                _joke.postValue(repository.getJokeForCategory(category))

            } catch (e: Exception) {
                Log.e("ERROR>>Joke", e.localizedMessage!!)
            }
        }
    }
}
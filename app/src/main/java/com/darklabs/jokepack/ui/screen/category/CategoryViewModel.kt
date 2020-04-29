package com.darklabs.jokepack.ui.screen.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.darklabs.jokepack.data.category.CategoryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {

    private val _jokeCategories = MutableLiveData<List<String>>()
    val jokeCategories: LiveData<List<String>> = _jokeCategories

    fun getJokeCategories() {
        GlobalScope.launch {
            try {
                _jokeCategories.postValue(repository.getJokeCategories())

            } catch (e: Exception) {
                Log.e("ERROR", e.localizedMessage)
            }
        }
    }
}
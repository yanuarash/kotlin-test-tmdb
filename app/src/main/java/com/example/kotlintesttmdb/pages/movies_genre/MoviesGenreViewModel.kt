package com.example.kotlintesttmdb.pages.movies_genre

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintesttmdb.network.Resource
import com.example.kotlintesttmdb.network.usecases.GenresUseCase
import com.example.kotlintesttmdb.network.usecases.MoviesGenreUseCase
import com.example.kotlintesttmdb.pages.home.GenresState
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.isActive

class MoviesGenreViewModel constructor(private val moviesGenreUseCase: MoviesGenreUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(MoviesGenreState())
    val state: State<MoviesGenreState> = _state

    fun getMoviesGenre(page: Int, withGenres: String) {
        val res = moviesGenreUseCase.invoke(page = page, withGenres = withGenres)
        res.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MoviesGenreState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = MoviesGenreState(isLoading = false, data = result.data)
                }

                is Resource.Error -> {
                    _state.value = MoviesGenreState(isLoading = false, error = result.message ?: "error getting data")
                }
            }
        }.launchIn(viewModelScope)
    }
}
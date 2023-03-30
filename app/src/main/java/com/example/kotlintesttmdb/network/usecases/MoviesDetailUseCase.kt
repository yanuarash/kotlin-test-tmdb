package com.example.kotlintesttmdb.network.usecases

import com.example.kotlintesttmdb.models.Genres
import com.example.kotlintesttmdb.models.MoviesDetail
import com.example.kotlintesttmdb.network.Resource
import com.example.kotlintesttmdb.network.repo.GenresRepo
import com.example.kotlintesttmdb.network.repo.MoviesDetailRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MoviesDetailUseCase constructor(private val moviesDetailRepo: MoviesDetailRepo) {
    operator fun invoke(movieId: Int): Flow<Resource<MoviesDetail>> = flow{
        try {
            emit(Resource.Loading())
            val res = moviesDetailRepo.getMoviesDetail(movieId)
            emit(Resource.Success(res))
        }
        catch (e: HttpException){
            emit(Resource.Error(message = e.message.toString()))
        }
        catch (e: IOException){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}
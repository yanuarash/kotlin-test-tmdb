package com.example.kotlintesttmdb.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kotlintesttmdb.navigation.NavigationItem
import com.example.kotlintesttmdb.pages.home.Home
import com.example.kotlintesttmdb.pages.movies_detail.MoviesDetail
import com.example.kotlintesttmdb.pages.movies_genre.MoviesGenre

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun NavigationPages(navHostController: NavHostController){
    NavHost(navController = navHostController,  startDestination = NavigationItem.Home.route){
        composable(NavigationItem.Home.route){
            Home(navHostController = navHostController)
        }

        composable(NavigationItem.MoviesGenre.route, arguments = listOf(navArgument("withGenres"){type = NavType.StringType})){
            val withGenres  = it.arguments?.getString("withGenres")
            MoviesGenre(withGenres = withGenres!!)
        }

        composable(NavigationItem.MoviesDetail.route, arguments = listOf(navArgument("movieId"){type = NavType.StringType})){
            val movieId  = it.arguments?.getString("movieId")?.toInt()
            MoviesDetail(movieId = movieId!!)
        }
    }
}
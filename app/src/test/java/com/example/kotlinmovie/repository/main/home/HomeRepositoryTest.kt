package com.example.kotlinmovie.repository.main.home

import com.example.kotlinmovie.TestUtil
import com.example.kotlinmovie.models.MovieListModel
import com.example.kotlinmovie.network.HomeApi
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HomeRepositoryTest {

//    val MOVIE_LIST_MODEL: MovieListModel = MovieListModel(TestUtil.MOVIE_LIST_MODEL)


    private lateinit var homeRepository: HomeRepository

    @Mock
    private lateinit var homeApi: HomeApi

    @BeforeEach
    private fun initBeforeEach(){
        MockitoAnnotations.initMocks(this)
        homeRepository= HomeRepository(homeApi)
    }

    @Test
    internal fun getMovies_returnSuccess() {
//        val movieListModel=TestUtil.MOVIE_LIST_MODEL
    }

    @Test
    internal fun getMovies_returnNull() {
        TODO("Not yet implemented")
    }

    @Test
    internal fun getMovies_returnError() {
        TODO("Not yet implemented")
    }

    @Test
    internal fun getMovies_results_null() {
        TODO("Not yet implemented")
    }
}
package com.example.kotlinmovie.ui.main.home

import com.example.kotlinmovie.repository.main.home.HomeRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel

    @Mock
    private lateinit var homeRepository: HomeRepository

    @BeforeEach
    internal fun initBeforeEach(){
        MockitoAnnotations.initMocks(this)
        homeViewModel= HomeViewModel(homeRepository)
    }

    @Test
    internal fun observeMovies_returnSuccess() {
        TODO("Not yet implemented")
    }

    @Test
    internal fun observeMovies_returnError() {
        TODO("Not yet implemented")
    }
}
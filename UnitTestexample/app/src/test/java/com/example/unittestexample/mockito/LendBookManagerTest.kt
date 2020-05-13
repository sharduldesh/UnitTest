package com.example.unittestexample.mockito

import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class LibraryManagementTest {
    @Test(expected = IllegalStateException::class)
    fun whenBookIsNotAvailable_thenAnExceptionIsThrown() {
        val mockBookService = Mockito.mock(BookService::class.java)  //mock BookService instance

        //whenever for kotlin mockito
        Mockito.`when`(mockBookService.inStock(100))
            .thenReturn(false) // we instruct mock instance to return false  i.e. book is not in stock

        val manager = LendBookManager(mockBookService)
        manager.checkout(100, 1)  //since inStock method returned false else part will be called
    }

    @Test
    fun whenBookIsAvailable_thenLendMethodIsCalled() {
        val mockBookService = Mockito.mock(BookService::class.java)
        Mockito.`when`(mockBookService.inStock(100)).thenReturn(true)

        val manager = LendBookManager(mockBookService)
        manager.checkout(100, 1)

        verify(mockBookService)
            .lend(100, 1)  //verify that the lend() method was called as a result of the operation
    }
}


/*
@Before
fun setUp() {
    MockitoAnnotations.initMocks(this)
    this.repository = Repository(this.apiInterface)
     lateinit homeViewModel = HomeViewModel(this.repository)
}

@Test
fun fetchRepositories_positiveResponse() {
    `when`(this.apiInterface.getList()).thenAnswer {
        return@thenAnswer Maybe.just(ArgumentMatchers.any<Repository>())
    }

    val observer = mock(Observer::class.java) as Observer<CountryModel>
    this.homeViewModel.CountryModel.observeForever(observer)

    verify(homeViewModel.getCountryInformation())

    assertNotNull(this.homeViewModel.CountryModel.value)
}

*/



package com.example.unittestexample.mockito

interface BookService {
    fun inStock(bookId: Int): Boolean
    fun lend(bookId: Int, memberId: Int)
}
package com.example.unittestexample.mockito

//BookService is injected at runtime so, for unit test we have to mock BookService
class LendBookManager(val bookService: BookService) {
    fun checkout(bookId: Int, memberId: Int) {
        if (bookService.inStock(bookId)) {
            bookService.lend(bookId, memberId)
        } else {
            throw IllegalStateException("Book is not available")
        }
    }
}

package com.peter.bookstoreapi.service

import com.peter.bookstoreapi.annotation.UnitTest
import com.peter.bookstoreapi.entity.BookStore
import com.peter.bookstoreapi.model.BookStoreDTO
import com.peter.bookstoreapi.model.dummy.BookStoreDummyFactory
import com.peter.bookstoreapi.repository.BookStoreRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import org.junit.jupiter.api.Test
import java.util.*


@UnitTest
internal class BookStoreServiceTest {

    private val bookStoreRepository: BookStoreRepository = mockk()

    @InjectMockKs
    private lateinit var bookStoreService: BookStoreService

    @Test
    fun getBookStore() {
        val id: Long = 1
        val bookStore: BookStore = BookStoreDummyFactory.generateBookStore()
        every { bookStoreRepository.findById(id) } returns Optional.of(bookStore)

        val result: BookStoreDTO = bookStoreService.getBookStore(id)
        println(result.toString())
    }
}
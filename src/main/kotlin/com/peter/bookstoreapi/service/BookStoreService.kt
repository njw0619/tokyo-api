package com.peter.bookstoreapi.service

import com.peter.bookstoreapi.entity.BookStore
import com.peter.bookstoreapi.model.BookStoreDTO
import com.peter.bookstoreapi.repository.BookStoreRepository
import org.springframework.stereotype.Service

@Service
class BookStoreService (
    private val bookStoreRepository: BookStoreRepository
){
    fun getBookStore(id: Long): BookStoreDTO {
        val bookStore: BookStore = bookStoreRepository.findById(id).orElseThrow { Exception() }
        return BookStoreDTO.of(bookStore)
    }
}
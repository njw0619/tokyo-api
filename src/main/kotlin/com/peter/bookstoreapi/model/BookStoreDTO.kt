package com.peter.bookstoreapi.model

import com.peter.bookstoreapi.entity.BookStore
import lombok.Builder
import java.time.Instant

@Builder
data class BookStoreDTO (
    val id: Long,
    val name: String,
    val createdAt: Instant,
    val updatedAt: Instant
){
    companion object {
        fun of(bookStore: BookStore): BookStoreDTO {
            return BookStoreDTO(
                id = bookStore.id,
                name = bookStore.name,
                createdAt = bookStore.createdAt,
                updatedAt = bookStore.updatedAt
            )
        }
    }
}
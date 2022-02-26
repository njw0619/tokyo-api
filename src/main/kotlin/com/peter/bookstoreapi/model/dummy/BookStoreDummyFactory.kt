package com.peter.bookstoreapi.model.dummy

import com.peter.bookstoreapi.entity.BookStore
import java.time.Instant

class BookStoreDummyFactory {
    companion object {
        fun generateBookStore (
            id: Long = 1,
            name: String = "Test1",
            createdAt: Instant = Instant.now(),
            updatedAt: Instant = Instant.now()
        ) = BookStore (
            id = id,
            name = name,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}
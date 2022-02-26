package com.peter.bookstoreapi.model

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.time.Instant


internal class BookStoreDTOTest {
    @BeforeEach
    fun setup() {

    }

    @AfterEach
    fun afterEach() {

    }

    @Test
    internal fun getId() {
        val bookStore = BookStoreDTO(
            id = 1,
            name = "Test1",
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )

        val id: Long = bookStore.id
        assertEquals(id, 1)
    }

    @Test
    internal fun getName() {
    }

    @Test
    internal fun getCreatedAt() {
    }

    @Test
    internal fun getUpdatedAt() {
    }
}

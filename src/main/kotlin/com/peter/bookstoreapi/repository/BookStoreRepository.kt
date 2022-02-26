package com.peter.bookstoreapi.repository

import com.peter.bookstoreapi.entity.BookStore
import org.springframework.stereotype.Repository


@Repository
interface BookStoreRepository: BaseRepository<BookStore, Long>
package com.peter.bookstoreapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookstoreApiApplication

fun main(args: Array<String>) {
	runApplication<BookstoreApiApplication>(*args)
}

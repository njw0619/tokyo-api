package com.peter.bookstoreapi.entity

import java.time.Instant
import javax.persistence.*

@Entity
@Table(catalog = BookStore.CATALOG, name = BookStore.TABLE)
class BookStore (

    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "createdAt")
    val createdAt: Instant,

    @Column(name = "updatedAt")
    val updatedAt: Instant
){
    companion object {
        const val CATALOG = "peter_store"
        const val TABLE = "book_store"
    }
}
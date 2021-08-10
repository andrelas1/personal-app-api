package com.andrelas1.papp.repository

import com.andrelas1.papp.model.Todo
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TodoRepository : JpaRepository<Todo?, Long?> {

    fun findByDescription(description: String?): List<Todo?>?

    override fun findById(id: Long): Optional<Todo?>
}
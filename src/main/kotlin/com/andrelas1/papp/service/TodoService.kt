package com.andrelas1.papp.service

import com.andrelas1.papp.model.Todo
import com.andrelas1.papp.repository.TodoRepository
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TodoService(private val repository: TodoRepository){

    @GetMapping("/todos")
    fun getAllTodos(): List<Todo?>? {
        return repository.findAll()
    }
}

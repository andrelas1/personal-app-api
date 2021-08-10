package com.andrelas1.papp.config

import com.andrelas1.papp.PappApplication
import com.andrelas1.papp.model.Todo
import com.andrelas1.papp.repository.TodoRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.slf4j.Logger;
import org.slf4j.LoggerFactory
import java.util.*

@Configuration
class Config {
    val log: Logger = LoggerFactory.getLogger(PappApplication::class.java)

    @Bean
    fun demo(repository: TodoRepository): CommandLineRunner? {
        return CommandLineRunner { args: Array<String?>? ->
            println("ADD STUFF TO THE DATABASE")
            // save a few customers
            repository.save(Todo("Buy Apple stock", "Investments"))
            repository.save(Todo("Do the laundry", "Home"))

            // fetch all customers
            println("Todos found with findAll():")
            println("-------------------------------")
            for (todo in repository.findAll()) {
                println(todo)
            }
            println("")

//        // fetch an individual customer by ID
            val todo: Optional<Todo?> = repository.findById(1L)
            println("Customer found with findById(1L):")
            println("--------------------------------")
            println(todo.toString())
            println("")

            // fetch customers by last name
            println("Todo found with findByDescription('Buy Apple stock'):")
            println("--------------------------------------------")
            repository.findByDescription("Buy Apple stock")?.forEach { description -> println("NAME: $description") }
            println("")

            // delete everything from the database
            println("Deleting all objects from the database")
            repository.deleteAll()
            repository.findAll().forEach { todo -> println("TODO: $todo")}
            println("--------------------------------------------")
        }
    }


}

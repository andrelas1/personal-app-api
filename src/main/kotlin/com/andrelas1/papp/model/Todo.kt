package com.andrelas1.papp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Todo(val description: String?, val tag: String?) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null
}
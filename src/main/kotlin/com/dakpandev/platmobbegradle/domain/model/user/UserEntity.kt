package com.dakpandev.platmobbegradle.domain.model.user

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.UUID
import jakarta.persistence.Id

@Entity
data class UserEntity(

    @Id
    @GeneratedValue(strategy = UUID)
    val id: String = "",

    val email: String = "",

    val username: String = "",

    val password: String = "",
)

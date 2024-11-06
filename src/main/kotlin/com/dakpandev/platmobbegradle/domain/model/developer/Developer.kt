package com.dakpandev.platmobbegradle.domain.model.developer

import jakarta.persistence.*
import jakarta.persistence.GenerationType.UUID

@Entity
@Table
data class Developer(

    @Id
    @GeneratedValue(strategy = UUID)
    val id: String = "",

    @Column(unique = true)
    val name: String = "",

    // TODO: add games
)

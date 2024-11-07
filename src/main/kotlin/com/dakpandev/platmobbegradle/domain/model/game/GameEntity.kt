package com.dakpandev.platmobbegradle.domain.model.game

import com.dakpandev.platmobbegradle.domain.model.developer.DeveloperEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table
data class GameEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String = "",

    @Column
    val name: String = "",

    @ManyToOne
    val developer: DeveloperEntity? = null,
)

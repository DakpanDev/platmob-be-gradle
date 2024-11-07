package com.dakpandev.platmobbegradle.domain.model.developer

import com.dakpandev.platmobbegradle.domain.model.game.GameEntity
import jakarta.persistence.*
import jakarta.persistence.GenerationType.UUID

@Entity
@Table
data class DeveloperEntity(

    @Id
    @GeneratedValue(strategy = UUID)
    val id: String = "",

    @Column(unique = true)
    val name: String = "",

    @Column
    val password: String = "",

    @OneToMany
    val games: List<GameEntity> = emptyList(),
)

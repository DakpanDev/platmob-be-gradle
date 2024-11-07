package com.dakpandev.platmobbegradle.domain.model.user

import com.dakpandev.platmobbegradle.domain.model.game.GameEntity
import jakarta.persistence.*
import jakarta.persistence.GenerationType.UUID

@Entity
@Table
data class UserEntity(

    @Id
    @GeneratedValue(strategy = UUID)
    val id: String = "",

    @Column(unique = true)
    val email: String = "",

    val username: String = "",

    val password: String = "",

    @OneToMany
    val games: List<GameEntity> = emptyList(),
)

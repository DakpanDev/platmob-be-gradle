package com.dakpandev.platmobbegradle.data.repository.user

import com.dakpandev.platmobbegradle.domain.model.user.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, String> {
    fun findOneByUsername(username: String): UserEntity?
}

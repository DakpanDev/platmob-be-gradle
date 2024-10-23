package com.dakpandev.platmobbegradle.service

import com.dakpandev.platmobbegradle.data.repository.user.UserRepository
import com.dakpandev.platmobbegradle.domain.model.user.LoginUser
import com.dakpandev.platmobbegradle.domain.model.user.UserEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
) {

    fun save(entity: UserEntity) = repository.save(entity)

    fun authenticate(loginUser: LoginUser) = repository
        .findOneByUsername(loginUser.username ?: "")
        ?.let { it.password == loginUser.password }
        ?: false
}

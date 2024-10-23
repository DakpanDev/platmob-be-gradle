package com.dakpandev.platmobbegradle.controller

import com.dakpandev.platmobbegradle.domain.model.user.LoginUser
import com.dakpandev.platmobbegradle.domain.model.user.UserEntity
import com.dakpandev.platmobbegradle.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController(
    private val service: UserService,
) {

    @PostMapping
    fun register(@RequestBody entity: UserEntity) = service.register(entity)

    @PostMapping("login")
    fun login(@RequestBody loginUser: LoginUser): Boolean {
        return service.authenticate(loginUser)
    }
}

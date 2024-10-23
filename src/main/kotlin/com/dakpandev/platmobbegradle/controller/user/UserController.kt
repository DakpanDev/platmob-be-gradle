package com.dakpandev.platmobbegradle.controller.user

import com.dakpandev.platmobbegradle.domain.generic.Response
import com.dakpandev.platmobbegradle.domain.generic.ResponseBody
import com.dakpandev.platmobbegradle.domain.generic.ResponseBody.Success
import com.dakpandev.platmobbegradle.domain.model.user.LoginUser
import com.dakpandev.platmobbegradle.domain.model.user.UserEntity
import com.dakpandev.platmobbegradle.service.UserService
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
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
    fun register(@RequestBody entity: UserEntity) = try {
        Response(
            Success(service.save(entity)),
            HttpStatusCode.valueOf(HttpStatus.CREATED.value()),
        )
    } catch (e: DataIntegrityViolationException) {
        Response(
            ResponseBody.Error("User with email address ${entity.email} already exists"),
            HttpStatusCode.valueOf(HttpStatus.NOT_ACCEPTABLE.value()),
        )
    }

    @PostMapping("login")
    fun login(@RequestBody loginUser: LoginUser) = if (service.authenticate(loginUser)) {
        Response(
            Success(true),
            HttpStatusCode.valueOf(HttpStatus.OK.value()),
        )
    } else {
        Response(
            Success(false),
            HttpStatusCode.valueOf(HttpStatus.UNAUTHORIZED.value()),
        )
    }
}

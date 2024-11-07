package com.dakpandev.platmobbegradle.controller.developer

import com.dakpandev.platmobbegradle.domain.generic.ApiResponse
import com.dakpandev.platmobbegradle.domain.generic.ResponseBody
import com.dakpandev.platmobbegradle.domain.generic.ResponseBody.Success
import com.dakpandev.platmobbegradle.domain.model.developer.DeveloperEntity
import com.dakpandev.platmobbegradle.domain.model.developer.LoginDeveloper
import com.dakpandev.platmobbegradle.service.developer.DeveloperService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dev")
class DeveloperController(
    private val service: DeveloperService,
) {

    @PostMapping
    fun register(@RequestBody entity: DeveloperEntity) = try {
        ApiResponse(
            Success(service.save(entity)),
            HttpStatusCode.valueOf(HttpStatus.CREATED.value()),
        )
    } catch (error: Exception) {
        ApiResponse(
            ResponseBody.Error("An error occurred while registering:\n$error"),
            HttpStatusCode.valueOf(HttpStatus.NOT_ACCEPTABLE.value()),
        )
    }

    @PostMapping("login")
    fun login(@RequestBody loginDeveloper: LoginDeveloper) = if (service.authenticate(loginDeveloper)) {
        ApiResponse(
            Success(true),
            HttpStatusCode.valueOf(HttpStatus.OK.value()),
        )
    } else {
        ApiResponse(
            Success(false),
            HttpStatusCode.valueOf(HttpStatus.UNAUTHORIZED.value()),
        )
    }
}

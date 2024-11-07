package com.dakpandev.platmobbegradle.service.developer

import com.dakpandev.platmobbegradle.data.repository.developer.DeveloperRepository
import com.dakpandev.platmobbegradle.domain.model.developer.DeveloperEntity
import com.dakpandev.platmobbegradle.domain.model.developer.LoginDeveloper
import org.springframework.stereotype.Service

@Service
class DeveloperService(
    private val repository: DeveloperRepository,
) {

    fun save(entity: DeveloperEntity) = repository.save(entity)

    fun authenticate(loginDeveloper: LoginDeveloper) = repository
        .findOneByName(loginDeveloper.name)
        ?.let { it.password == loginDeveloper.password } == true
}

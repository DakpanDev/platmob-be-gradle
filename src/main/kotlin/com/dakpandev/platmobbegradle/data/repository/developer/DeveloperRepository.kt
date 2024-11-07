package com.dakpandev.platmobbegradle.data.repository.developer

import com.dakpandev.platmobbegradle.domain.model.developer.DeveloperEntity
import org.springframework.data.repository.CrudRepository

interface DeveloperRepository : CrudRepository<DeveloperEntity, String> {
    fun findOneByName(name: String): DeveloperEntity?
}

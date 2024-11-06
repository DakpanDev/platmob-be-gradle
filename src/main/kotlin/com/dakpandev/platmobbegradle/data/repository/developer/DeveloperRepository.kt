package com.dakpandev.platmobbegradle.data.repository.developer

import com.dakpandev.platmobbegradle.domain.model.developer.Developer
import org.springframework.data.repository.CrudRepository

interface DeveloperRepository : CrudRepository<Developer, String>

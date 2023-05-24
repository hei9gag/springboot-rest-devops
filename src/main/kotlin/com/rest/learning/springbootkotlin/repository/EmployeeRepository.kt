package com.rest.learning.springbootkotlin.repository

import com.rest.learning.springbootkotlin.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface EmployeeRepository: JpaRepository<Employee, UUID>
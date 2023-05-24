package com.rest.learning.springbootkotlin.service

import com.rest.learning.springbootkotlin.model.Employee
import com.rest.learning.springbootkotlin.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface EmployeeService {
    fun getAllEmployee(): List<Employee>
}

@Service
class EmployeeServiceImpl(
    @Autowired
    val employeeRepository: EmployeeRepository
) : EmployeeService {

    override fun getAllEmployee(): List<Employee> {
        return employeeRepository.findAll()
    }
}

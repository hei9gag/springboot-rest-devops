package com.rest.learning.springbootkotlin.controller

import com.rest.learning.springbootkotlin.model.Employee
import com.rest.learning.springbootkotlin.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/employee")
class EmployeeController(
    @Autowired
    val employeeService: EmployeeService
) {

    @GetMapping
    fun fetchAllEmployees(): ResponseEntity<List<Employee>> {
        val employees = employeeService.getAllEmployee()
        return ResponseEntity(employees, HttpStatus.OK)
    }
}
package com.rest.learning.springbootkotlin
import com.rest.learning.springbootkotlin.model.Employee
import com.rest.learning.springbootkotlin.repository.EmployeeRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class LoadDatabase {

    private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)

    @Bean
    fun initDatabase(repository: EmployeeRepository): CommandLineRunner? {
        return CommandLineRunner {
            log.info("Preloading " + repository.save(Employee(name = "Brian")))
            log.info("Preloading " + repository.save(Employee(name = "Peter")))
        }
    }
}
package com.deepblue.cruddemo.rest

import com.deepblue.cruddemo.dao.EmployeeDAO
import com.deepblue.cruddemo.entity.Employee
import com.deepblue.cruddemo.service.EmployeeService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmployeeRestController(
    private val employeeService: EmployeeService
) {
    @GetMapping("/employees")
    fun findAll(): List<Employee> {
        return employeeService.listAll()
    }

    @GetMapping("/employees/{employeeId}")
    fun getById(@PathVariable employeeId: Int): Employee {
        val employee= employeeService.findById(employeeId)?: throw RuntimeException("Employee id not found $employeeId")

        return employee
    }

    @PostMapping("/employees")
    fun addEmployee(@RequestBody newEmployee: Employee): Employee {
        newEmployee.setId(0)
        return employeeService.save(newEmployee)
    }

    @PutMapping("/employees")
    fun udateEmployees(@RequestBody theEmployee: Employee): Employee {
        return employeeService.save(theEmployee)
    }

    @DeleteMapping("/employees/{employeeId}")
    fun deleteById(@PathVariable employeeId: Int): String{
        val employee= employeeService.findById(employeeId)?: throw RuntimeException("Employee id not found $employeeId")

        employeeService.deleteById(employeeId)
        return "employee with ID $employeeId deleted"
    }
}
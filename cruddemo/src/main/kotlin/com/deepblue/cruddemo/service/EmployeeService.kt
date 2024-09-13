package com.deepblue.cruddemo.service

import com.deepblue.cruddemo.entity.Employee

interface EmployeeService {
    fun listAll(): List<Employee>
    fun findById(id: Int): Employee
    fun save(employee: Employee): Employee
    fun deleteById(id: Int)
}
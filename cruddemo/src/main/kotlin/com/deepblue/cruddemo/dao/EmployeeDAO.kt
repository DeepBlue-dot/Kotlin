package com.deepblue.cruddemo.dao

import com.deepblue.cruddemo.entity.Employee

interface EmployeeDAO {
    fun findAll(): List<Employee>
    fun findById(id: Int): Employee
    fun save(employee: Employee): Employee
    fun deleteById(id: Int)
}
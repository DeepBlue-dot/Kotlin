package com.deepblue.cruddemo.dao

import com.deepblue.cruddemo.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path="Employees")
interface EmployeeRepository: JpaRepository<Employee, Int> {
}
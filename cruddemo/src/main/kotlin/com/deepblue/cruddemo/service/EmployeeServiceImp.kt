package com.deepblue.cruddemo.service

import com.deepblue.cruddemo.dao.EmployeeDAO
import com.deepblue.cruddemo.entity.Employee
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeServiceImp(
    private val employeeDAO: EmployeeDAO
): EmployeeService {
    override fun listAll(): List<Employee> {
        return employeeDAO.findAll()
    }

    override fun findById(id: Int): Employee {
        return employeeDAO.findById(id)
    }

    @Transactional
    override fun deleteById(id: Int) {
        employeeDAO.deleteById(id)
    }

    @Transactional
    override fun save(employee: Employee): Employee {
        return employeeDAO.save(employee)
    }
}
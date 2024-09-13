package com.deepblue.cruddemo.dao

import com.deepblue.cruddemo.entity.Employee
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import org.springframework.stereotype.Repository

@Repository
class EmployeeDAOImp(
    private val entityManager: EntityManager
): EmployeeDAO {

    override fun findAll(): List<Employee> {
        val theQuery: TypedQuery<Employee> = entityManager.createQuery("FROM Employee", Employee::class.java)
        return theQuery.resultList
    }

    override fun findById(id: Int): Employee {
        return entityManager.find(Employee::class.java, id)
    }

    override fun save(employee: Employee): Employee {
        return entityManager.merge(employee)
    }

    override fun deleteById(id: Int) {
        val emp = entityManager.find(Employee::class.java, id)
        entityManager.remove(emp)
    }
}
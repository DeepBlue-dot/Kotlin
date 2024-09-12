package com.deepblue.DBdemo.dao

import com.deepblue.DBdemo.entity.Student

interface StudentDAO {
    fun save(student: Student)
    fun findById(id: Int): Student?
    fun findAll(): List<Student>
    fun findByLastName(lastName: String): List<Student>
    fun udateStudent(stud: Student)
    fun deleteStudent(stud: Student)
    fun deleteAll(): Boolean
}
package com.deepblue.DBdemo.dao

import com.deepblue.DBdemo.entity.Student
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class StudentDAOImple (private var entityManager: EntityManager): StudentDAO {

    override fun save(student: Student) {
        entityManager.persist(student)
    }

    override fun findById(id: Int): Student? {
        return entityManager.find(Student::class.java, id)
    }

    override fun findAll(): List<Student> {
        val query: TypedQuery<Student> = entityManager.createQuery(
            "FROM Student ORDER BY _lastName", Student::class.java
        )
        return query.resultList
    }

    override fun findByLastName(lastName: String): List<Student> {
        val query = entityManager.createQuery("FROM Student WHERE _lastName = :lastName", Student::class.java)
        query.setParameter("lastName", lastName)
        return query.resultList
    }

    @Transactional
    override fun udateStudent(stud: Student) {
        entityManager.merge(stud)
    }
    @Transactional
    override fun deleteStudent(stud: Student) {
        val stu = entityManager.find(Student::class.java, stud.getId())
        entityManager.remove(stu)
    }
    @Transactional
    override fun deleteAll(): Boolean {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate() > 0
    }

}
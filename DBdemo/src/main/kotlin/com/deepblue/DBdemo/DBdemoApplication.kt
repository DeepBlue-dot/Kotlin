package com.deepblue.DBdemo

import com.deepblue.DBdemo.dao.StudentDAO
import com.deepblue.DBdemo.entity.Student
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean


@SpringBootApplication
class DBdemoApplication {
	@Bean
	fun commandLineRunner(sudentDAO: StudentDAO): CommandLineRunner {
		return CommandLineRunner {
			sudentDAO.deleteAll()
			createStudent(sudentDAO)
			readStudent(sudentDAO,2)
			listAllStudent(sudentDAO)
			readStudentByLastName(sudentDAO, "fikadu")
			updateStudent(sudentDAO)
			deleteStudent(sudentDAO, 120)
		}
	}
	fun createStudent(studDAO: StudentDAO) {
		for (i in 1..10) {
			val student: Student = Student("yeabsira$i", "fikadu$i", "yeabsira$i");
			studDAO.save(student)
		}
	}

	fun readStudent(studDAO: StudentDAO, id: Int) {
		val stud = studDAO.findById(id) ?: "Student not found"
		println(stud)
	}

	fun readStudentByLastName(studDAO: StudentDAO, lastName: String) {
		val stud = studDAO.findByLastName(lastName)
		for (stu in stud) {
			println(stu)
		}
	}


	fun listAllStudent(studDAO: StudentDAO) {
		val allStudent = studDAO.findAll()
		for (stud in allStudent) {
			println(stud)
		}
	}

	fun updateStudent(studDAO: StudentDAO) {
		var stu = studDAO.findById(4)?: return
		stu.setFirstName("bigMan")
		studDAO.udateStudent(stu)
		readStudent(studDAO, stu.getId())
	}
	fun deleteStudent(studDAO: StudentDAO, id: Int) {
		val stu = studDAO.findById(id)?: return
		readStudent(studDAO, id)
		studDAO.deleteStudent(stu)
	}
}

fun main(args: Array<String>) {
	runApplication<DBdemoApplication>(*args)
}

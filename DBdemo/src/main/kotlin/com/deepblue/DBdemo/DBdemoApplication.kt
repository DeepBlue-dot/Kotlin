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
			createStudent(sudentDAO)
			readStudent(sudentDAO,2)
			listAllStudent(sudentDAO)
			readStudentByLastName(sudentDAO, "fikadu")
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

}

fun main(args: Array<String>) {
	runApplication<DBdemoApplication>(*args)
}

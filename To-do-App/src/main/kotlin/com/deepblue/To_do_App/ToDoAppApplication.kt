package com.deepblue.To_do_App

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoAppApplication

fun main(args: Array<String>) {
	runApplication<ToDoAppApplication>(*args)
}

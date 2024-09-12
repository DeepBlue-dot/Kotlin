package com.deepblue.To_do_App.Rest

import com.deepblue.To_do_App.entity.TaskErrorResponse
import com.deepblue.To_do_App.error.TaskNotFound
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class TaskRestExceptionHandler {

    @ExceptionHandler
    fun handleTaskNotFunde(exc: TaskNotFound): ResponseEntity<TaskErrorResponse> {
        val message = exc.message ?: "Task not found"
        val error = TaskErrorResponse(HttpStatus.NOT_FOUND.value(), message)

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun allErrorHandler(exc: Exception) : ResponseEntity<TaskErrorResponse> {
        val message = exc.message ?: "Task not found"
        val error = TaskErrorResponse(HttpStatus.BAD_REQUEST.value(), message)

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}
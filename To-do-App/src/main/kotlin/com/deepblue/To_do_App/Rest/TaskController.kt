package com.deepblue.To_do_App.Rest

import com.deepblue.To_do_App.entity.Task
import com.deepblue.To_do_App.entity.TaskErrorResponse
import com.deepblue.To_do_App.error.TaskNotFound
import jakarta.annotation.PostConstruct
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api")
class TaskController {

    lateinit var allTasks: List<Task>

    @PostConstruct
    fun loadData() {
        allTasks = listOf(
            Task(
                id = 1,
                title = "Complete Project Report",
                description = "Finish the final draft of the project report and submit it to the supervisor.",
            ),
            Task(
                id = 2,
                title = "Team Meeting",
                description = "Attend the weekly team meeting to discuss project progress and next steps.",
            ),
            Task(
                id = 3,
                title = "Update Software",
                description = "Apply the latest updates and patches to the software system.",
            ),
            Task(
                id = 4,
                title = "Write Blog Post",
                description = "Draft and publish a new blog post about the recent technology trends.",
            ),
            Task(
                id = 5,
                title = "Client Feedback",
                description = "Collect and review feedback from the client regarding the latest product release.",

                )
        )
    }

    @GetMapping("/all")
    fun taskList(): List<Task> {
        return allTasks
    }

    @GetMapping("/task/{taskId}")
    fun getTaskId(@PathVariable taskId: Int): Task {
        if (taskId < 0 || taskId > allTasks.size) {
            throw TaskNotFound("Task Id Not Found $taskId")
        }
        return allTasks.get(taskId)
    }

}



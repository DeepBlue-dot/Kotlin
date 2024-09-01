import java.util.Scanner

fun main() {
    println("Todo List Manager")
    val tasks = mutableListOf<Task>()
    val scanner = Scanner(System.`in`)
    var choice = ""

    do {
        println("\n1. Add a new task")
        println("2. List all tasks")
        println("3. Mark a task as complete")
        println("4. Remove a task")
        println("q. Quit")
        print("Enter your choice: ")
        choice = scanner.nextLine()

        when (choice) {
            "1" -> addTask(tasks, scanner)
            "2" -> listTasks(tasks)
            "3" -> markTaskComplete(tasks, scanner)
            "4" -> removeTask(tasks, scanner)
            "q" -> println("Exiting...")
            else -> println("Invalid choice. Please try again.")
        }
    } while (choice != "q")
}

fun addTask(tasks: MutableList<Task>, scanner: Scanner) {
    print("Enter task description: ")
    val value = scanner.nextLine()
    tasks.add(Task(value, 0))
    println("Task added.")
}

fun listTasks(tasks: MutableList<Task>) {
    if (tasks.isEmpty()) {
        println("No tasks available.")
    } else {
        println("List of tasks:")
        tasks.forEachIndexed { index, task ->
            println("${index + 1}. ${task.value} - ${task.taskStatus()}")
        }
    }
}

fun markTaskComplete(tasks: MutableList<Task>, scanner: Scanner) {
    listTasks(tasks)
    if (tasks.isNotEmpty()) {
        print("Enter task number to mark as complete: ")
        val index = scanner.nextLine().toIntOrNull()?.minus(1)
        if (index != null && index in tasks.indices) {
            val task = tasks[index]
            tasks[index] = Task(task.value, 1) // Update status to 1 (Complete)
            println("Task marked as complete.")
        } else {
            println("Invalid task number.")
        }
    }
}

fun removeTask(tasks: MutableList<Task>, scanner: Scanner) {
    listTasks(tasks)
    if (tasks.isNotEmpty()) {
        print("Enter task number to remove: ")
        val index = scanner.nextLine().toIntOrNull()?.minus(1)
        if (index != null && index in tasks.indices) {
            tasks.removeAt(index)
            println("Task removed.")
        } else {
            println("Invalid task number.")
        }
    }
}

class Task(val value: String, val status: Int) {
    fun taskStatus(): String {
        return if (status == 0) "Incomplete" else "Complete"
    }
}

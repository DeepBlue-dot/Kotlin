package com.deepblue.To_do_App.entity

import java.time.LocalDateTime

class Task(
    private var id: Long,
    private var title: String,
    private var description: String,
    private var status: TaskStatus = TaskStatus.PENDING,
    private var createdAt: LocalDateTime = LocalDateTime.now(),
    private var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    // Getters
    fun getId(): Long = id

    fun getTitle(): String = title

    fun getDescription(): String = description

    fun getStatus(): TaskStatus = status

    fun getCreatedAt(): LocalDateTime = createdAt

    fun getUpdatedAt(): LocalDateTime = updatedAt

    // Setters
    fun setId(newId: Long) {
        id = newId
    }

    fun setTitle(newTitle: String) {
        title = newTitle
    }

    fun setDescription(newDescription: String) {
        description = newDescription
    }

    fun setStatus(newStatus: TaskStatus) {
        status = newStatus
    }

    fun setCreatedAt(newCreatedAt: LocalDateTime) {
        createdAt = newCreatedAt
    }

    fun setUpdatedAt(newUpdatedAt: LocalDateTime) {
        updatedAt = newUpdatedAt
    }

}



enum class TaskStatus {
    PENDING, COMPLETED
}

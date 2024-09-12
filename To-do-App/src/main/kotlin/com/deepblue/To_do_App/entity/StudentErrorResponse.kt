package com.deepblue.To_do_App.entity

import java.time.LocalDateTime

class TaskErrorResponse (
    private var status: Int,
    private var message: String ="",
    private var timestamp: LocalDateTime = LocalDateTime.now(),
) {
    fun getStatus():Int = status
    fun getMessage(): String = message
    fun getTimeStamp():LocalDateTime = timestamp
    fun setStatus(status:Int) {
        this.status =status
    }
    fun setMessage(message: String) {
        this.message =message
    }
    fun setTimeStamp(timestamp: LocalDateTime) {
        this.timestamp = timestamp
    }


}
package com.deepblue.To_do_App.error


class TaskNotFound : RuntimeException {
    constructor(message: String) : super(message)
}

package com.deepblue.To_do_App.Rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class MainController {
    @GetMapping()
    fun hello(): String {
        return "Hello world"
    }

}
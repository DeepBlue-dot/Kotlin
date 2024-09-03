package com.deepblue.springboot.tutorials.thenewboston

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping

@RestController
@RequestMapping("api/hello")
class HelloWorldController {
    @GetMapping
    fun helloworld() :String = "hello world"
}
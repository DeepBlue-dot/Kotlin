package com.springboot.demo

import com.springboot.demo.Component.Coach
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController(val coah: Coach, @Value("\${server.port}") val port: String) {

    @Autowired
    lateinit var coah2: Coach

    @GetMapping("")
    fun home(): String {
        return "<h1>Hello world $port</h1>"
    }

    @GetMapping("workout")
    fun workout(): String {
        return coah.getWorkOut()
    }
}

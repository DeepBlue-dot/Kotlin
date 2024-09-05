package com.springboot.demo

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Value

@RestController
class AppController (
    @Value("\${server.port}") val port:String
    ) 
{
    @GetMapping("")
    fun home(): String {
        return "<h1>Hello world $port</h1>"
    }

}
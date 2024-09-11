package com.springboot.demo.Component

import com.springboot.demo.Component.Coach

import org.springframework.stereotype.Component

@Component
class CricketCoach: Coach {
    override fun getWorkOut(): String {
        return "<h1>I am not here</h1>"
    }
}
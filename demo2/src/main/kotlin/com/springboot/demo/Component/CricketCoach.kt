package com.springboot.demo.Component

import com.springboot.demo.Component.Coach
import org.springframework.stereotype.Component
import org.springframework.context.annotation.Primary

@Component
@Primary
class CricketCoach: Coach {
    init {
        println("CricketCoach created")
    }
    override fun getWorkOut(): String {
        return "i am a  BaseballCoach"
    }
}
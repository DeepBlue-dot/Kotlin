package com.springboot.demo.Component


import com.springboot.demo.Component.Coach
import org.springframework.stereotype.Component
import org.springframework.context.annotation.Lazy


@Component
@Lazy
class TennisCoach : Coach {
    init {
        println("TennisCoach created")
    }

    override fun getWorkOut(): String {
        return "i am a TennisCoach"
    }
}

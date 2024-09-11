package com.springboot.demo.Component


import org.springframework.stereotype.Component
import com.springboot.demo.Component.Coach


@Component
class  TrackCoach: Coach {
    init {
        println("TrackCoach created")
    }

    override fun getWorkOut(): String {
        return "i am a  TrackCoach"
    }
}
package com.springboot.demo

import com.springboot.demo.Component.Coach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController(
    @Qualifier("cricketCoach") val cricketCoach: Coach
) {

    @Autowired
    @Qualifier("trackCoach")
    lateinit var trackCoach: Coach

    lateinit var baseballCoach: Coach

    @Autowired
    fun setCoach(@Qualifier("baseballCoach") baseballCoach: Coach) {
        this.baseballCoach = baseballCoach
    }

    @GetMapping("")
    fun home(): String {
        return "<h1>Hello world</h1>"
    }

    @GetMapping("workout")
    fun workout(): String {
        return trackCoach.getWorkOut()
    }
}

package com.springboot.demo.Component

import org.springframework.stereotype.Component
import com.springboot.demo.Component.Coach
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class BaseballCoach: Coach {
    init {
        println("BaseballCoach created")
    }

    @PostConstruct
    fun postConstruct(){
        println("i am created")
    }

    @PreDestroy
    fun preDestroy(){
        println("i am destroyed")
    }

    override fun getWorkOut(): String {
        return "i am a  BaseballCoach"
    }
}
package com.baby.services.baby.activity.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["com.baby.services.baby.activity"])
class BabyActivityServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(BabyActivityServiceApplication::class.java, *args)
}
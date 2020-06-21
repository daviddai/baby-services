package com.baby.services.baby.profile.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["com.baby.services.baby.profile"])
class BabyProfileServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(BabyProfileServiceApplication::class.java, *args)
}
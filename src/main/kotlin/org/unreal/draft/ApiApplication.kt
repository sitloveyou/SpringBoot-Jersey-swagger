package org.unreal.draft

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableAutoConfiguration
class ApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiApplication::class.java, *args)
}

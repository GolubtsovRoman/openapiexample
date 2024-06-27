package ru.golubtsov

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication(Application::class.java).run(*args)
    println("Go to swagger: http://localhost:8080/swagger-ui.html")
}

package com.antosha4e.alpha

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication(scanBasePackageClasses = [Application::class])
class Application : SpringBootServletInitializer()

fun main(args: Array<String>)
{
    SpringApplication.run(Application::class.java, *args)
}

package com.serverless

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@EnableAutoConfiguration
@Configuration
@Import(Config::class, SnackQueryResolver::class)
class Application: SpringBootServletInitializer() {
//    @Bean
//    fun servletRegistrationBean(): ServletRegistrationBean<*> {
//        return ServletRegistrationBean(SimpleGraphQLHttpServlet(), "/graphql/*")
//    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}


package com.serverless

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.web.servlet.HandlerAdapter
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.HandlerMapping
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

@Configuration
@EnableWebMvc
@Profile("lambda")
class Config {
    @Bean
    fun handlerMapping(): HandlerMapping {
        return RequestMappingHandlerMapping()
    }

    @Bean
    fun handlerAdapter(): HandlerAdapter {
        return RequestMappingHandlerAdapter()
    }

    @Bean
    @Primary
    fun handlerExceptionResolver(): HandlerExceptionResolver {
        return HandlerExceptionResolver { _, _, _, _ -> null }
    }
}
package com.serverless

import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestHandler {
    @GetMapping("/graphiql")
    fun getIt(): HttpEntity<String> = ResponseEntity.ok().body("Foo")
}
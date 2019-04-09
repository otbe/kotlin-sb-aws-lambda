package com.serverless

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class SnackQueryResolver : GraphQLQueryResolver {
    fun snacks(): List<Snack> {
        return listOf(Snack("1", "Name"), Snack("2", "Name13"))
    }
}
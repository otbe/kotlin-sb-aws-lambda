package com.serverless

import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import java.io.InputStream
import java.io.OutputStream


class Handler : RequestStreamHandler {
    private var handler: SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>? = null

    override fun handleRequest(inputStream: InputStream, outputStream: OutputStream, context: Context) {
        if (handler == null) {
            try {
                handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(Application::class.java)
                handler!!.activateSpringProfiles("lambda")
            } catch (e: ContainerInitializationException) {
                e.printStackTrace()
                throw RuntimeException("Could not initialize Spring Boot application", e)
            }

        }

        handler!!.proxyStream(inputStream, outputStream, context)
    }
}



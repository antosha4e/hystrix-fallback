package com.antosha4e.beta.service.client

import com.antosha4e.alpha.client.DefaultApi
import com.antosha4e.alpha.model.AlphaRequest
import com.antosha4e.alpha.model.AlphaResponse
import com.antosha4e.beta.dto.BetaRequest
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.hystrix.HystrixFeign
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AlphaServiceClient {

    private val log: Logger = LoggerFactory.getLogger(AlphaServiceClient::class.java)

    private val target: DefaultApi =
            HystrixFeign.builder()
                    .encoder(GsonEncoder())
                    .decoder(GsonDecoder())
                    .target(DefaultApi::class.java, "http://localhost:8081")


    fun getAlphaResponse(request: BetaRequest): AlphaResponse? {
        return try {
            target.makeCall(AlphaRequest().alphaNumber(request.betaNumber))
        }
        catch (ex: Exception) {
            log.error("Exception while retrieving value: ", ex)
            null
        }
    }
}

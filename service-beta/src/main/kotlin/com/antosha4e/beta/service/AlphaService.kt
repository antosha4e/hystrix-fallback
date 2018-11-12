package com.antosha4e.beta.service

import com.antosha4e.alpha.model.AlphaResponse
import com.antosha4e.beta.dto.BetaRequest
import com.antosha4e.beta.service.client.AlphaServiceClient
import org.springframework.stereotype.Service

@Service
class AlphaService(
        private val alphaServiceClient: AlphaServiceClient
) {

    fun getAlphaValue(request: BetaRequest): AlphaResponse? {

        return alphaServiceClient.getAlphaResponse(request)
    }
}

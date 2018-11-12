package com.antosha4e.beta.controller

import com.antosha4e.beta.dto.BetaRequest
import com.antosha4e.beta.dto.BetaResponse
import com.antosha4e.beta.service.AlphaService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/you-beta-answer")
class BetaController(
    private val alphaService: AlphaService
) {

    private val log = LoggerFactory.getLogger(BetaController::class.java)

    @PostMapping
    fun makeCall(@Valid @RequestBody request: BetaRequest): ResponseEntity<BetaResponse> {
        log.info("Request: {}", request)

        return alphaService.getAlphaValue(request)?.let{
            log.info("Response: {}", it)
            ResponseEntity.ok(BetaResponse(it.alphaAnswer))
        } ?: ResponseEntity.noContent().build()
    }
}

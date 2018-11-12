package com.antosha4e.alpha.controller

import com.antosha4e.alpha.dto.AlphaRequest
import com.antosha4e.alpha.dto.AlphaResponse
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/alpha-to-omega")
class AlphaController {

    private val log = LoggerFactory.getLogger(AlphaController::class.java)

    @PostMapping
    fun makeCall(@Valid @RequestBody request: AlphaRequest): ResponseEntity<AlphaResponse> {

        log.info("Request: {}", request)

        return makeLogic(request)?.let {

            log.info("Response: {}", it)

            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }


    private fun makeLogic(request: AlphaRequest): AlphaResponse? {
        return if (request.alphaNumber > 100) AlphaResponse("OK") else null
    }
}

package com.baby.services.baby.activity.api

import com.baby.services.baby.activity.model.dto.BabyActivityDto
import com.baby.services.baby.activity.model.http.request.CreateBabyActivityRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RequestMapping("/activity")
interface BabyActivityApi {

    @PostMapping("/add")
    fun add(@RequestBody createBabyActivityRequest: CreateBabyActivityRequest): ResponseEntity<Mono<BabyActivityDto>>

    @GetMapping("/{babyProfileRef}/{id}")
    fun getByBabyProfileRefAndActivityId(@PathVariable("babyProfileRef") babyProfileRef: String,
                                         @PathVariable("id") id: Long): ResponseEntity<Mono<BabyActivityDto>>

    @GetMapping("/{babyProfileRef}/all")
    fun getAllByBabyProfileRef(@PathVariable("babyProfileRef") babyProfileRef: String): ResponseEntity<Flux<BabyActivityDto>>

}
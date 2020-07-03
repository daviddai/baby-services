package com.baby.services.baby.profile.api

import com.baby.services.baby.profile.model.http.request.CreateBabyProfileRequest
import com.baby.services.baby.profile.model.dto.BabyProfileDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RequestMapping("/profile")
interface BabyProfileApi {

    @PostMapping("/add")
    fun add(@RequestBody createBabyProfileRequest: CreateBabyProfileRequest): ResponseEntity<Mono<BabyProfileDto>>

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): ResponseEntity<Mono<BabyProfileDto?>>

    @GetMapping("/all")
    fun getAll(): ResponseEntity<Flux<BabyProfileDto>>

    @DeleteMapping("/remove/{id}")
    fun removeById(@PathVariable("id") id: Long)

}
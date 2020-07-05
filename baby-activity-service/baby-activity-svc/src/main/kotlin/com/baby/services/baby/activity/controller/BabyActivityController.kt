package com.baby.services.baby.activity.controller

import com.baby.services.baby.activity.api.BabyActivityApi
import com.baby.services.baby.activity.model.dto.BabyActivityDto
import com.baby.services.baby.activity.model.http.request.CreateBabyActivityRequest
import com.baby.services.baby.activity.service.BabyActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/activity")
class BabyActivityController: BabyActivityApi {

    @Autowired
    private lateinit var babyActivityService: BabyActivityService

    @PostMapping("/add")
    override fun add(createBabyActivityRequest: CreateBabyActivityRequest): ResponseEntity<Mono<BabyActivityDto>> =
        ResponseEntity.ok(babyActivityService.addBabyActivity(createBabyActivityRequest))

    @GetMapping("/{babyProfileRef}/{id}")
    override fun getByBabyProfileRefAndActivityId(@PathVariable("babyProfileRef") babyProfileRef: String,
                                                  @PathVariable("id") id: Long): ResponseEntity<Mono<BabyActivityDto>> =
        ResponseEntity.ok(babyActivityService.findBabyActivity(babyProfileRef, id))

    @GetMapping("/{babyProfileRef}/all")
    override fun getAllByBabyProfileRef(@PathVariable("babyProfileRef") babyProfileRef: String): ResponseEntity<Flux<BabyActivityDto>> =
        ResponseEntity.ok(babyActivityService.findAllBabyActivity(babyProfileRef))

}
package com.baby.services.baby.profile.controller

import com.baby.services.baby.profile.api.BabyProfileApi
import com.baby.services.baby.profile.model.http.request.CreateBabyProfileRequest
import com.baby.services.baby.profile.model.dto.BabyProfileDto
import com.baby.services.baby.profile.service.BabyProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/profile")
class BabyProfileController: BabyProfileApi {

    @Autowired
    private lateinit var babyProfileService: BabyProfileService

    @PostMapping("/add")
    override fun add(@RequestBody createBabyProfileRequest: CreateBabyProfileRequest): Mono<BabyProfileDto> =
        babyProfileService.createNewBabyProfile(createBabyProfileRequest)

    @GetMapping("/{id}")
    override fun getById(@PathVariable("id") id: Long): Mono<BabyProfileDto?> = babyProfileService.findBabyProfile(id)

    @GetMapping("/all", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    override fun getAll(): Flux<BabyProfileDto> =
        babyProfileService.getAllProfiles()

    @DeleteMapping("/remove/{id}")
    override fun removeById(@PathVariable("id") id: Long) =
        babyProfileService.removeBabyProfileById(id)
}
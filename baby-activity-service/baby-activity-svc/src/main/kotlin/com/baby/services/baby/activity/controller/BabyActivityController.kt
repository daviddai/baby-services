package com.baby.services.baby.activity.controller

import com.baby.services.baby.activity.api.BabyActivityApi
import com.baby.services.baby.activity.model.dto.BabyActivityDto
import com.baby.services.baby.activity.model.http.request.CreateBabyActivityRequest
import com.baby.services.baby.activity.service.BabyActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/activity")
class BabyActivityController: BabyActivityApi {

    @Autowired
    private lateinit var babyActivityService: BabyActivityService

    @PostMapping("/add")
    override fun add(createBabyActivityRequest: CreateBabyActivityRequest): BabyActivityDto =
        babyActivityService.addBabyActivity(createBabyActivityRequest)

    @GetMapping("/{babyProfileRef}/{id}")
    override fun getByBabyProfileRefAndActivityId(@PathVariable("babyProfileRef") babyProfileRef: String,
                                                  @PathVariable("id") id: Long): BabyActivityDto? =
        babyActivityService.findBabyActivity(babyProfileRef, id)?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "Baby activity for baby profile ref $babyProfileRef activity id $id not found")

    @GetMapping("/{babyProfileRef}/all")
    override fun getAllByBabyProfileRef(@PathVariable("babyProfileRef") babyProfileRef: String): List<BabyActivityDto>? =
        babyActivityService.findAllBabyActivity(babyProfileRef)?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "Baby activities for $babyProfileRef not found")

}
package com.baby.services.baby.activity.api

import com.baby.services.baby.activity.model.dto.BabyActivityDto
import com.baby.services.baby.activity.model.http.request.CreateBabyActivityRequest
import org.springframework.web.bind.annotation.*

@RequestMapping("/activity")
interface BabyActivityApi {

    @PostMapping("/add")
    fun add(@RequestBody createBabyActivityRequest: CreateBabyActivityRequest): BabyActivityDto

    @GetMapping("/{babyProfileRef}/{id}")
    fun getByBabyProfileRefAndActivityId(@PathVariable("babyProfileRef") babyProfileRef: String,
                                         @PathVariable("id") id: Long): BabyActivityDto?

    @GetMapping("/{babyProfileRef}/all")
    fun getAllByBabyProfileRef(@PathVariable("babyProfileRef") babyProfileRef: String): List<BabyActivityDto>?

}
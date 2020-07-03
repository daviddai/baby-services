package com.baby.services.baby.profile.api

import com.baby.services.baby.profile.model.http.request.CreateBabyProfileRequest
import com.baby.services.baby.profile.model.dto.BabyProfileDto
import org.springframework.web.bind.annotation.*

@RequestMapping("/profile")
interface BabyProfileApi {

    @PostMapping("/add")
    fun add(@RequestBody createBabyProfileRequest: CreateBabyProfileRequest): BabyProfileDto

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): BabyProfileDto?

    @GetMapping("/all")
    fun getAll(): List<BabyProfileDto>

    @DeleteMapping("/remove/{id}")
    fun removeById(@PathVariable("id") id: Long)

}
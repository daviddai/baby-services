package com.baby.services.baby.profile.controller

import com.baby.services.baby.profile.api.BabyProfileApi
import com.baby.services.baby.profile.model.http.request.CreateBabyProfileRequest
import com.baby.services.baby.profile.model.http.response.BabyProfileDto
import com.baby.services.baby.profile.service.BabyProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/profile")
class BabyProfileController: BabyProfileApi {

    @Autowired
    private lateinit var babyProfileService: BabyProfileService

    @PostMapping("/add")
    override fun add(@RequestBody createBabyProfileRequest: CreateBabyProfileRequest): BabyProfileDto =
        babyProfileService.createNewBabyProfile(createBabyProfileRequest)

    @GetMapping("/{id}")
    override fun getById(@PathVariable("id") id: Long): BabyProfileDto? = babyProfileService.findBabyProfileById(id) ?: throw Exception("Baby profile cannot be found")

    @GetMapping("/all")
    override fun getAll(): List<BabyProfileDto> =
        babyProfileService.getAllProfiles()

    @DeleteMapping("/remove/{id}")
    override fun removeById(@PathVariable("id") id: Long) =
        babyProfileService.removeBabyProfileById(id)
}
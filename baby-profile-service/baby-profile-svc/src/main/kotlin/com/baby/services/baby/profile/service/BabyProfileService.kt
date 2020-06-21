package com.baby.services.baby.profile.service

import com.baby.services.baby.profile.model.http.request.CreateBabyProfileRequest
import com.baby.services.baby.profile.model.http.response.BabyProfileDto
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class BabyProfileService {
    val counter = AtomicLong()

    companion object {
        var babyProfilesLookup = mutableMapOf<Long, BabyProfileDto>()
    }

    fun createNewBabyProfile(createBabyProfileRequest: CreateBabyProfileRequest): BabyProfileDto {
        val babyProfileDto = BabyProfileDto(counter.getAndIncrement(),
            createBabyProfileRequest.firstName,
            createBabyProfileRequest.otherGivenNames,
            createBabyProfileRequest.lastName,
            createBabyProfileRequest.gender,
            createBabyProfileRequest.dateOfBirth)

        babyProfilesLookup[babyProfileDto.id] = babyProfileDto

        return babyProfileDto
    }

    fun findBabyProfileById(id: Long): BabyProfileDto? = babyProfilesLookup[id]

    fun getAllProfiles(): List<BabyProfileDto> = babyProfilesLookup.values.toList()

    fun removeBabyProfileById(id: Long) {
        babyProfilesLookup.remove(id)
    }
}
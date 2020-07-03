package com.baby.services.baby.profile.service

import com.baby.services.baby.profile.model.http.request.CreateBabyProfileRequest
import com.baby.services.baby.profile.model.dto.BabyProfileDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.util.*
import java.util.concurrent.atomic.AtomicLong

@Service
class BabyProfileService {
    val counter = AtomicLong()

    companion object {
        var babyProfilesLookup = mutableMapOf<Long, BabyProfileDto>()
    }

    fun createNewBabyProfile(createBabyProfileRequest: CreateBabyProfileRequest): Mono<BabyProfileDto> {
        val babyProfileDto = BabyProfileDto(
            counter.getAndIncrement(),
            UUID.randomUUID().toString(),
            createBabyProfileRequest.firstName,
            createBabyProfileRequest.otherGivenNames,
            createBabyProfileRequest.lastName,
            createBabyProfileRequest.gender,
            createBabyProfileRequest.dateOfBirth
        )

        babyProfilesLookup[babyProfileDto.id] = babyProfileDto

        return Mono.just(babyProfileDto)
    }

    fun findBabyProfile(id: Long): Mono<BabyProfileDto?> = Mono.justOrEmpty(babyProfilesLookup[id])

    fun getAllProfiles(): List<BabyProfileDto> = babyProfilesLookup.values.toList()

    fun removeBabyProfileById(id: Long) {
        babyProfilesLookup.remove(id)
    }
}
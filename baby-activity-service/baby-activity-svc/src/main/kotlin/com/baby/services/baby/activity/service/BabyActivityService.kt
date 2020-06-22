package com.baby.services.baby.activity.service

import com.baby.services.baby.activity.model.dto.BabyActivityDto
import com.baby.services.baby.activity.model.http.request.CreateBabyActivityRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong

@Service
class BabyActivityService {

    val counter = AtomicLong()

    companion object {
        var babyActivityLookup = mutableMapOf<String, MutableMap<Long, BabyActivityDto>>()
    }

    fun addBabyActivity(createBabyActivityRequest: CreateBabyActivityRequest): BabyActivityDto {
        val babyActivityDto = convertToBabyActivityDto(createBabyActivityRequest)
        val babyProfileRefToActivities = babyActivityLookup.getOrDefault(createBabyActivityRequest.babyProfileRef, mutableMapOf())
        babyProfileRefToActivities[babyActivityDto.id] = babyActivityDto
        return babyActivityDto
    }

    fun findBabyActivity(babyProfileRef: String, id: Long) = babyActivityLookup[babyProfileRef]?.get(id)

    fun findAllBabyActivity(babyProfileRef: String) = babyActivityLookup[babyProfileRef]?.values?.toList()

    private fun convertToBabyActivityDto(createBabyActivityRequest: CreateBabyActivityRequest) = BabyActivityDto(
        createBabyActivityRequest.babyProfileRef,
        counter.getAndIncrement(),
        createBabyActivityRequest.type,
        LocalDateTime.parse(createBabyActivityRequest.dateAndTime) ?: LocalDateTime.now(),
        createBabyActivityRequest.note)
}
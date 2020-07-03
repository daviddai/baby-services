package com.baby.services.baby.profile.model.dto

data class BabyProfileDto(val id: Long,
                          val babyProfileRef: String,
                          val firstName: String,
                          val otherGivenNames: String?,
                          val lastName: String,
                          val gender: String,
                          val dateOfBirth: String)
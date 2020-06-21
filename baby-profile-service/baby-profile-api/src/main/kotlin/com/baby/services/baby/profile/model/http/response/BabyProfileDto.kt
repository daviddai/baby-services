package com.baby.services.baby.profile.model.http.response

data class BabyProfileDto(val id: Long,
                          val firstName: String,
                          val otherGivenNames: String?,
                          val lastName: String,
                          val gender: String,
                          val dateOfBirth: String)
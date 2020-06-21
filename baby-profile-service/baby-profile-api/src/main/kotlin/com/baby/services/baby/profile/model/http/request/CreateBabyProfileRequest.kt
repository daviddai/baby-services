package com.baby.services.baby.profile.model.http.request

data class CreateBabyProfileRequest(val firstName: String,
                                    val otherGivenNames: String?,
                                    val lastName: String,
                                    val gender: String,
                                    val dateOfBirth: String)
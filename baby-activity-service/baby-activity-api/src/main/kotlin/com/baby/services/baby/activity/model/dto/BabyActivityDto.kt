package com.baby.services.baby.activity.model.dto

import com.baby.services.baby.activity.model.enum.BabyActivityType
import java.time.LocalDateTime

data class BabyActivityDto(val babyProfileRef: String,
                           val id: Long,
                           val type: BabyActivityType,
                           val dateAndTime: LocalDateTime,
                           val note: String?)
package com.baby.services.baby.activity.model.http.request

import com.baby.services.baby.activity.model.enum.BabyActivityType

data class CreateBabyActivityRequest(val babyProfileRef: String,
                                     val type: BabyActivityType,
                                     val dateAndTime: String?,
                                     val note: String?)
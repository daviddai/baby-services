package com.baby.services.baby.activity.service

import com.baby.services.baby.activity.model.enum.BabyActivityType
import com.baby.services.baby.activity.model.http.request.CreateBabyActivityRequest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class BabyActivityServiceTest {

    private var babyActivityService = BabyActivityService()

    @Test
    fun `CreateBabyActivityRequest should be correctly convert to BabyActivityDto and stored in babyActivityLookup`() {
        val createBabyActivityRequest = getCreateBabyActivityRequest()
        val babyActivityDto = babyActivityService.addBabyActivity(createBabyActivityRequest)
        assertNotNull(babyActivityDto)

        assertEquals(0, babyActivityDto.id)
        assertEquals(createBabyActivityRequest.babyProfileRef, babyActivityDto.babyProfileRef)
        assertEquals(createBabyActivityRequest.dateAndTime, babyActivityDto.dateAndTime.toString())
        assertEquals(createBabyActivityRequest.note, babyActivityDto.note)

        assertEquals(babyActivityDto, babyActivityService.findBabyActivity(createBabyActivityRequest.babyProfileRef, babyActivityDto.id))
    }

    private fun getCreateBabyActivityRequest(): CreateBabyActivityRequest = CreateBabyActivityRequest(
        "babyProfileRef-01",
        BabyActivityType.FEEDING,
        "2020-06-22T13:00",
        "Breast feeding"
    )
}
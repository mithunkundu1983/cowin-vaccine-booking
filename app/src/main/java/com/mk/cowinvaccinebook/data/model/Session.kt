package com.mk.cowinvaccinebook.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Session(
    @Json(name = "available_capacity")
    val availableCapacity: Int?,
    @Json(name="available_capacity_dose1")
    val availableCapacity_d1: Int?,
    @Json(name="available_capacity_dose2")
    val availableCapacity_d2: Int?,
    @Json(name = "date")
    val date: String?,
    @Json(name = "min_age_limit")
    val minAgeLimit: Int?,
    @Json(name = "session_id")
    val sessionId: String,
    @Json(name = "slots")
    val slots: List<String>?,
    @Json(name = "vaccine")
    val vaccine: String?
)
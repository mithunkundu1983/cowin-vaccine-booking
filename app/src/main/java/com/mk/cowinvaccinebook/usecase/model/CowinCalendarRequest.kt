package com.mk.cowinvaccinebook.usecase.model

sealed class CowinCalendarRequest {
    class DistrictCowinCalendarRequest(val districtId: Int): CowinCalendarRequest()
    class PinCowinCalendarRequest(val pincode: String): CowinCalendarRequest()
}
package com.mk.cowinvaccinebook.usecase

import com.mk.cowinvaccinebook.data.model.ApiResult
import com.mk.cowinvaccinebook.data.model.CowinCalendarResponse
import com.mk.cowinvaccinebook.repository.CowinAppRepository
import com.mk.cowinvaccinebook.usecase.model.CowinCalendarRequest
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class FetchVaccinationCentersUseCase @Inject constructor(
    private val cowinAppRepository: CowinAppRepository
): BaseUseCase<CowinCalendarRequest, ApiResult<CowinCalendarResponse>>() {
    override suspend fun execute(input: CowinCalendarRequest): ApiResult<CowinCalendarResponse> {
        val date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        return  when(input) {
            is CowinCalendarRequest.DistrictCowinCalendarRequest ->
                cowinAppRepository.getCalendarByDistrict(input.districtId, date)
            is CowinCalendarRequest.PinCowinCalendarRequest ->
                cowinAppRepository.getCalendarByPinCode(input.pincode, date)
        }
    }
}
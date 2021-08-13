package com.mk.cowinvaccinebook.usecase

import com.mk.cowinvaccinebook.data.model.ApiResult
import com.mk.cowinvaccinebook.data.model.ScheduleAppointmentResponse
import com.mk.cowinvaccinebook.repository.CowinAppRepository
import com.mk.cowinvaccinebook.usecase.model.ScheduleAppointmentRequest
import javax.inject.Inject


class ScheduleAppointmentUseCase @Inject constructor(
    private val cowinAppRepository: CowinAppRepository
): BaseUseCase<ScheduleAppointmentRequest, ApiResult<ScheduleAppointmentResponse>>() {
    override suspend fun execute(input: ScheduleAppointmentRequest): ApiResult<ScheduleAppointmentResponse> {
        return cowinAppRepository.scheduleAppointment(input)
    }
}
package com.mk.cowinvaccinebook.usecase

import com.mk.cowinvaccinebook.data.model.ApiResult
import com.mk.cowinvaccinebook.data.model.CaptchaResponse
import com.mk.cowinvaccinebook.repository.CowinAppRepository
import javax.inject.Inject

class GetReCaptchaUseCase @Inject constructor(
    private val cowinAppRepository: CowinAppRepository
): BaseUseCase<Unit, ApiResult<CaptchaResponse>>() {
    override suspend fun execute(input: Unit): ApiResult<CaptchaResponse> {
        return cowinAppRepository.generateCaptcha()
    }
}
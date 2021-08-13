package com.mk.cowinvaccinebook.usecase

import com.mk.cowinvaccinebook.data.model.ApiResult
import com.mk.cowinvaccinebook.data.model.StatesResponse
import com.mk.cowinvaccinebook.repository.CowinAppRepository
import javax.inject.Inject

class GetStatesUseCase @Inject constructor(
    private val cowinAppRepository: CowinAppRepository
): BaseUseCase<Unit, ApiResult<StatesResponse>>() {
    override suspend fun execute(input: Unit): ApiResult<StatesResponse> {
        return cowinAppRepository.getStates()
    }
}
package com.mk.cowinvaccinebook.usecase

import com.mk.cowinvaccinebook.data.model.BeneficiarySummary
import com.mk.cowinvaccinebook.repository.CowinAppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveBeneficiarySummaryUseCase @Inject constructor(
    private val cowinAppRepository: CowinAppRepository
): BaseFlowUseCase<Unit, List<BeneficiarySummary>>() {
    override fun execute(input: Unit): Flow<List<BeneficiarySummary>> {
        return cowinAppRepository.observeBeneficiarySummary()
    }
}
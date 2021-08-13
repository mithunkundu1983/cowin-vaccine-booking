package com.mk.cowinvaccinebook.usecase

import com.mk.cowinvaccinebook.repository.CowinAppRepository
import com.mk.cowinvaccinebook.usecase.model.UserPreferenceAndBeneficiaries
import javax.inject.Inject

class SaveUserPreferenceUseCase @Inject constructor(
    private  val cowinAppRepository: CowinAppRepository
): BaseUseCase<UserPreferenceAndBeneficiaries, Unit>() {
    override suspend fun execute(input: UserPreferenceAndBeneficiaries) {
        cowinAppRepository.saveBeneficiaryDetails(input.beneficiaries)
        cowinAppRepository.saveUserPreference(input.userPreference)
    }
}
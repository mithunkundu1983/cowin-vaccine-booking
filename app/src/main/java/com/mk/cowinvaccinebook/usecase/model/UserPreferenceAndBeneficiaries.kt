package com.mk.cowinvaccinebook.usecase.model

import com.mk.cowinvaccinebook.data.model.BeneficiarySummary

class UserPreferenceAndBeneficiaries(
    val userPreference: UserPreference,
    val beneficiaries: List<BeneficiarySummary>
)
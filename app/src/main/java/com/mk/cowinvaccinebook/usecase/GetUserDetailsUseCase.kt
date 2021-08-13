package com.mk.cowinvaccinebook.usecase

import com.mk.cowinvaccinebook.data.model.UserDetails
import com.mk.cowinvaccinebook.repository.CowinAppRepository
import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
    private val cowinAppRepository: CowinAppRepository
): BaseUseCase<Unit, UserDetails?>() {
    override suspend fun execute(input: Unit): UserDetails? {
        return cowinAppRepository.getSavedMobileNum()?.let {
            UserDetails(it)
        }
    }

}
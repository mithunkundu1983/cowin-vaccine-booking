package com.mk.cowinvaccinebook.usecase

abstract class BaseUseCase<Input, Output> {
    abstract suspend fun execute(input: Input): Output
}
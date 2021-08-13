package com.mk.cowinvaccinebook.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import com.mk.cowinvaccinebook.R
import com.mk.cowinvaccinebook.databinding.FragmentSplashBinding
import com.mk.cowinvaccinebook.viewmodel.SplashFragmentViewModel

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentViewModel, FragmentSplashBinding>() {

    companion object {
        @JvmStatic
        fun newInstance() = SplashFragment()
    }

    override val viewModel: SplashFragmentViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_splash, container, false)


    override fun observeViewModel() {
        super.observeViewModel()
        viewLifecycleOwner.apply {
            viewModel.onOpenScreen.observe(this) {
                when(it) {
                    SplashFragmentViewModel.USER_DETAILS_ENTRY -> findNavController()
                        .navigate(R.id.action_splashFragment_to_userDetailsEntryFragment)
                    SplashFragmentViewModel.BENEFICIARY_SCREEN -> findNavController()
                        .navigate(R.id.action_splashFragment_to_beneficiaryDetailsFragment)
                }
            }
        }
    }


}
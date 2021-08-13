package com.mk.cowinvaccinebook.view.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.mk.cowinvaccinebook.R
import com.mk.cowinvaccinebook.viewmodel.MainActivityViewModel


@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityViewModel>() {

    override val viewModel: MainActivityViewModel by viewModels()
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
            }
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.onRequestOverlayPermission.observe(this) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
                resultLauncher.launch(intent)
            }
        }
    }
}
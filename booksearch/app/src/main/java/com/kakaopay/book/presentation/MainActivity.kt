package com.kakaopay.book.presentation

import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.kakaopay.book.databinding.ActivityMainBinding
import com.kakaopay.book.R
import com.kakaopay.book.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>() {

    override val viewModel by viewModels<MainViewModel>()

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    private lateinit var navController: NavController

    override fun initState() {
        super.initState()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun observeData() {

    }


}
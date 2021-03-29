package com.armboldmind.gsport.presentation.di

import com.armboldmind.gsport.presentation.uscase.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PresentationModule = module {

    viewModel { HomeViewModel() }

}
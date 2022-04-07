package com.example.gb_4_3_exam.di

import com.example.gb_4_3_exam.data.datasource.RemoteDataSource
import com.example.gb_4_3_exam.data.datasource.RemoteDataSourceMock
import com.example.gb_4_3_exam.data.repository.DataRepositoryImpl
import com.example.gb_4_3_exam.domain.repository.DataRepository
import com.example.gb_4_3_exam.presentation.viewmodel.HomeViewModel
import com.example.gb_4_3_exam.presentation.viewmodel.TimetableViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DI {
    fun getModule() = module {
        single<RemoteDataSource> { RemoteDataSourceMock() }

        single<DataRepository> { DataRepositoryImpl(remoteDataSource = get()) }

        viewModel { HomeViewModel(dataRepository = get()) }

        viewModel { TimetableViewModel(dataRepository = get()) }
    }
}

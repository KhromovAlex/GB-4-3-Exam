package com.example.gb_4_3_exam

import android.app.Application
import com.example.gb_4_3_exam.di.DI
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                DI.getModule()
            )
        }
    }
}

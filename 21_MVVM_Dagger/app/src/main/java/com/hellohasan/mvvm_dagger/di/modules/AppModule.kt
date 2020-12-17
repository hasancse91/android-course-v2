package com.hellohasan.mvvm_dagger.di.modules

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.hellohasan.mvvm_dagger.core.AppViewModelFactory
import com.hellohasan.mvvm_dagger.data.local.db.AppDatabase
import com.hellohasan.mvvm_dagger.data.local.db.DatabaseBuilder
import com.hellohasan.mvvm_dagger.data.local.preference.AppPreference
import com.hellohasan.mvvm_dagger.data.local.preference.AppPreferenceImpl
import com.hellohasan.mvvm_dagger.di.annotation.ApplicationContext
import com.hellohasan.mvvm_dagger.utils.DATABASE_NAME
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun provideContext(application: Application): Context

    @Binds
    abstract fun provideAppPreference(appPreferenceImpl: AppPreferenceImpl): AppPreference

    @Binds
    abstract fun provideViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideLocalDb(@ApplicationContext context: Context) : AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}
package com.hellohasan.mvvm_dagger.di

import android.app.Application
import com.hellohasan.mvvm_dagger.core.App
import com.hellohasan.mvvm_dagger.di.builders.ActivityBuilder
import com.hellohasan.mvvm_dagger.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        LocalDataSource::class,
        RemoteSourceModule::class,
        RepositoryModule::class,
        ViewModelModule::class]
)
@Singleton interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
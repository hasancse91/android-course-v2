package com.hellohasan.mvvm_dagger.di.modules

import com.hellohasan.mvvm_dagger.data.remote.RetrofitClient
import com.hellohasan.mvvm_dagger.data.remote.ip_info.IpInfoRetrofitInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RemoteSourceModule {

    @Provides
    @Singleton
    fun provideIpInfoRemoteSource(): IpInfoRetrofitInterface {
        return RetrofitClient.getClient().create(IpInfoRetrofitInterface::class.java)
    }
}
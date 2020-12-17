package com.hellohasan.mvvm_dagger.data.remote

import android.content.Context

object RemoteSourceFactory {

    fun <RemoteSource> create(context: Context, remoteSourceClass: Class<RemoteSource>): RemoteSource {
        return RetrofitClient.getClient().create(remoteSourceClass)
    }
}
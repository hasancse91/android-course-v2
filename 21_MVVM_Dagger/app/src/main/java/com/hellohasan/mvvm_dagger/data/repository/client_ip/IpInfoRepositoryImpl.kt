package com.hellohasan.mvvm_dagger.data.repository.client_ip

import android.content.Context
import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.local.preference.AppPreference
import com.hellohasan.mvvm_dagger.data.local.preference.AppPreference.Companion.IP_ADDRESS
import com.hellohasan.mvvm_dagger.data.local.preference.AppPreference.Companion.IP_TYPE
import com.hellohasan.mvvm_dagger.data.local.preference.AppPreferenceImpl
import com.hellohasan.mvvm_dagger.data.remote.ip_info.IpInfoRemoteSource
import com.hellohasan.mvvm_dagger.data.remote.ip_info.IpInfoRemoteSourceImpl
import com.hellohasan.mvvm_dagger.di.annotation.ApplicationContext
import com.hellohasan.mvvm_dagger.utils.isInternetAvailable
import javax.inject.Inject

class IpInfoRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val ipInfoRemoteSource: IpInfoRemoteSource,
    private val appPreference: AppPreference
) : IpInfoRepository {

    override fun getClientInfo(callback: DataFetchCallback<IpInfo>) {

        if (isInternetAvailable(context)) {
            ipInfoRemoteSource.getIpInfo(object : DataFetchCallback<IpInfo> {

                override fun onSuccess(data: IpInfo) {

                    saveIpInfoInPreference(data)

                    data.isOnline = true
                    callback.onSuccess(data)
                }

                override fun onError(throwable: Throwable) {
                    callback.onError(throwable)
                }
            })
        } else {
            val ipAddress = appPreference.getString(IP_ADDRESS)
            val ipType = appPreference.getString(IP_TYPE)

            if (ipAddress.isNotEmpty() && ipType.isNotEmpty()) {
                callback.onSuccess(
                    IpInfo(
                        ipString = ipAddress,
                        ipType = ipType,
                        isOnline = false
                    )
                )
            } else {
                callback.onError(Throwable("Device is offline and no cached data found"))
            }
        }
    }

    private fun saveIpInfoInPreference(data: IpInfo) {
        data.ipString?.let { appPreference.setString(IP_ADDRESS, it) }
        data.ipType?.let { appPreference.setString(IP_TYPE, it) }
    }
}
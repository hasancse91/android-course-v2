package com.hellohasan.mvvm_dagger.data.remote.ip_info

import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfo

interface IpInfoRemoteSource {
    fun getIpInfo(callback: DataFetchCallback<IpInfo>)
}
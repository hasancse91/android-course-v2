package com.hellohasan.mvvm_dagger.data.repository.client_ip

import com.hellohasan.mvvm_dagger.core.DataFetchCallback

interface IpInfoRepository {
    fun getClientInfo(callback: DataFetchCallback<IpInfo>)
}
package com.hellohasan.room_orm.data.remote.ip_info

import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.repository.client_ip.IpInfo

interface IpInfoRemoteSource {
    fun getIpInfo(callback: DataFetchCallback<IpInfo>)
}
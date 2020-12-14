package com.hellohasan.room_orm.data.repository.client_ip

import com.hellohasan.room_orm.core.DataFetchCallback

interface IpInfoRepository {
    fun getClientInfo(callback: DataFetchCallback<IpInfo>)
}
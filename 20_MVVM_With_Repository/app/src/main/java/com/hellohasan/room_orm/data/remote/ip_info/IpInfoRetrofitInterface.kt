package com.hellohasan.room_orm.data.remote.ip_info

import com.hellohasan.room_orm.data.repository.client_ip.IpInfo
import retrofit2.Call
import retrofit2.http.GET

interface IpInfoRetrofitInterface {

    @GET("client-ip")
    fun getClientIp(): Call<IpInfo>
}
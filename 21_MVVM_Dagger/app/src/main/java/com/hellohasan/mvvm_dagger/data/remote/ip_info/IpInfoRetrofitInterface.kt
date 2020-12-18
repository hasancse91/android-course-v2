package com.hellohasan.mvvm_dagger.data.remote.ip_info

import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfo
import retrofit2.Call
import retrofit2.http.GET

interface IpInfoRetrofitInterface {

    @GET("client-ip")
    fun getClientIp(): Call<IpInfo>
}
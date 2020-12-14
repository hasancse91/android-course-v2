package com.hellohasan.room_orm.data.remote.ip_info

import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.remote.RetrofitClient
import com.hellohasan.room_orm.data.repository.client_ip.IpInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IpInfoRemoteSourceImpl(): IpInfoRemoteSource {

    override fun getIpInfo(callback: DataFetchCallback<IpInfo>) {

        val ipInfoRetrofitInterface = RetrofitClient.getClient().create(IpInfoRetrofitInterface::class.java)
        val call = ipInfoRetrofitInterface.getClientIp()

        call.enqueue(object : Callback<IpInfo> {

            override fun onResponse(call: Call<IpInfo>, response: Response<IpInfo>) {
                if (response.isSuccessful && response.body() != null) {
                    callback.onSuccess(requireNotNull(response.body()))
                } else {
                    callback.onError(Throwable(response.message()))
                }
            }

            override fun onFailure(call: Call<IpInfo>, t: Throwable) {
                callback.onError(t)
            }
        })
    }
}
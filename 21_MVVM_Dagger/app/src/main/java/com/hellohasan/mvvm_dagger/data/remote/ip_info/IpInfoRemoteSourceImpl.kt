package com.hellohasan.mvvm_dagger.data.remote.ip_info

import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.remote.RetrofitClient
import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class IpInfoRemoteSourceImpl @Inject constructor(private val ipInfoRetrofitInterface: IpInfoRetrofitInterface): IpInfoRemoteSource {

    override fun getIpInfo(callback: DataFetchCallback<IpInfo>) {

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
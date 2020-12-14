package com.hellohasan.room_orm.data.repository.client_ip

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class IpInfo(
    @SerializedName("ipNumeric")
    val ipNumeric: Long? = null,
    @SerializedName("ipString")
    val ipString: String?,
    @SerializedName("ipType")
    val ipType: String? = null,
    @SerializedName("isBehindProxy")
    val isBehindProxy: Boolean? = null,
    var isOnline: Boolean = true
) {
    override fun toString(): String {
        return "IP Address: $ipString\n" +
                "IP Type: $ipType\n" +
                "Device Online? - $isOnline"
    }
}
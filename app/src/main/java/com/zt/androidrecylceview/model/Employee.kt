package com.zt.androidrecylceview.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Employee : Serializable {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("url")
    var data: Data? = null

    @SerializedName("timestamp")
    var timestamp: String? = null

    inner class Data : Serializable {
        @SerializedName("small")
        var small: String? = null

        @SerializedName("medium")
        var medium: String? = null

        @SerializedName("large")
        var large: String? = null
    }
}
package com.darklabs.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Joke(
    @SerialName("id") val id: String,
    @SerialName("value") val value: String,
    @SerialName("icon_url") val icon_url: String,
    @SerialName("url") val url: String
)
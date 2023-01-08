package com.isl.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Sign(
    val name:String,
    val pronounce:String,
    val description:String,
    val imageUrl:String
)

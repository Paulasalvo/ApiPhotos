package com.desafio.apiphotos.model.dto

data class PhotosDTO(
    val albumId:Int,
    val id:Int,
    val title:String,
    val url:String,
    val thumbNailUrl:String
)


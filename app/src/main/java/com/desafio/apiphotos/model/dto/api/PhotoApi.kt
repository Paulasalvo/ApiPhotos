package com.desafio.apiphotos.model.dto.api

import com.desafio.apiphotos.model.dto.PhotosDTO
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PhotoApi {
    @GET("/photos")
    suspend fun getPhotosList(): List<PhotosDTO>
}

private fun getPhotosListClient(): Retrofit {
    return Retrofit.Builder()
        .client(OkHttpClient())
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
fun getPhotosListService():PhotoApi{
    return getPhotosListClient().create(PhotoApi::class.java)
}
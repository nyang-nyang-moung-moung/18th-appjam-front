package com.example.appjam18.Utils

import com.example.appjam18.Data.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST

interface Services {
    @POST("/signup")
    fun register(
        @Body register: Register
    ): Call<ResultRegister>

    @POST("/signin")
    fun login(
        @Body login: Login
    ): Call<ResultLogin>

    @Multipart
    @POST("/setPicture")
    fun picture(@Body thumbnail: image): Call<Result_image>
}
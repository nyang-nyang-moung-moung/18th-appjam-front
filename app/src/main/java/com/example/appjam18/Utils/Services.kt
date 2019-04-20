package com.example.appjam18.Utils

import com.example.appjam18.Data.Login
import com.example.appjam18.Data.Register
import com.example.appjam18.Data.ResultLogin
import com.example.appjam18.Data.ResultRegister
import retrofit2.Call
import retrofit2.http.Body
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
}
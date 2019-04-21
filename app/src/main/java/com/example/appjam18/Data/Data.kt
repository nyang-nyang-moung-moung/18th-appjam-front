package com.example.appjam18.Data

import android.content.Intent

data class Register(val id: String, val password: String, val name: String, val age: Int)

data class Login(val id: String, val password: String)

data class ResultLogin(val success: Boolean, val message: String)

data class ResultRegister(val success: Boolean, val message: String)

data class image(val picture: Intent?)

data class Result_image(val success: Boolean, val message: String)



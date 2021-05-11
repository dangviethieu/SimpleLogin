package com.hieudv.cloudlawai.data.api.services

import com.hieudv.cloudlawai.data.api.request_body.LoginRequestBody
import com.hieudv.cloudlawai.data.api.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("auth/login")
    fun login(@Body loginBody: LoginRequestBody): Call<LoginResponse>
}
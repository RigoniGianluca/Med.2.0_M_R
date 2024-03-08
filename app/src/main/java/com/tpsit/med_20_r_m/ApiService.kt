package com.tpsit.med_20_r_m

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("register")
    fun registerUser(
        @Body user: User
    ): Call<UserResponse>
}

package com.tpsit.med_20_r_m

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("add_user")
    fun RegisterUser(@Body user: User): Call<Void>

    /*@POST("login")
    fun login(@Body credenziali: CredenzialiLogin): Call<Void>*/
}

package com.example.covid19

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("indonesia")
    fun getData(): Call<ArrayList<CovidModel>>
}
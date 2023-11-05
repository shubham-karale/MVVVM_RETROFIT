package com.example.mvvvm_retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteInterface {

    @GET("quotes")

//    NOTE: BASE_URL + QUOTES + ?page=1

    suspend fun getQuotes(@Query("page") page : Int): Response<Quotes>

}
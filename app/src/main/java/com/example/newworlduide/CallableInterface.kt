package com.nwg.newworlduide

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CallableInterface {

    // https://newworldfans.com/api/v1/dev_tracker?page=1&source=reddit
    // https://newworldfans.com/api/v1/dev_tracker



    @GET("/api/v1/dev_tracker?")
    fun getNews(@Query("source") source: String?): Call<List<Article>>



}
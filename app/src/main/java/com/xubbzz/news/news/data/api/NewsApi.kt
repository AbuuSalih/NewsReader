package com.xubbzz.news.news.data.api

import retrofit2.http.GET

interface NewsApi {

    @GET("/NewsAPI/top-headlines/category/science/in.json")
    suspend fun getNews(): NewsNetModel
}
package com.example.movie_project.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class movie_api
{
   companion object
   {
       private  var retrofit : Retrofit? = null
       private var BASE_URL : String = "https://api.themoviedb.org/3/"
       var APIKey : String = "c52a827e70fb473d0ee1f066a815c5b7"


       fun getMovi_Services () : Retrofit?
       {
           var httpLoggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor()
           httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
           var okHttpClient : OkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

           if(retrofit==null){
               retrofit=  Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .client(okHttpClient)
                   .build();
           }
           return retrofit
       }

   }
}
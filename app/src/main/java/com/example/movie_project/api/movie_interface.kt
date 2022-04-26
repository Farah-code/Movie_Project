package com.example.movie_project.api

import android.database.Observable
import biz.filmeroo.premier.mywork.model.Movie_Model
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface movie_interface
{
    @GET("movie/top_rated")
    fun getTopRated(@Query("api_key") apiKey : String) : Observable<Movie_Model>

    @GET
    fun getMovieDetials (@Path("id")  id : Int, @Query("api_key")  apiKey : String) : Observable<Movie_Model>




}
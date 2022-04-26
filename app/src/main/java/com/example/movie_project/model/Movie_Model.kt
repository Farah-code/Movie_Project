package biz.filmeroo.premier.mywork.model

import com.google.gson.annotations.SerializedName



 data class Movie_Model (
      @SerializedName("adult")
      var adult : String,
      @SerializedName("backdrop_path")
      var backdrop_path : String,
      @SerializedName("belongs_to_collection")
      var belongs_to_collection : String,
      @SerializedName("budget")
      var budget : Int,
      @SerializedName("genres")
      var genres : List<genric>,
      @SerializedName("homepage")
      var homepage : String,
      @SerializedName("id")
      var id : Int,
      @SerializedName("imdb_id")
      var imdb_id : String,
      @SerializedName("original_language")
      var original_language : String,
      @SerializedName("original_title")
      var original_title : String,
      @SerializedName("overview")
      var overview : String,
      @SerializedName("popularity")
      var popularity: Int,
      @SerializedName("poster_path")
      var poster_path : String,
      @SerializedName("productionCompany")
      var productionCompany: List<production_company>,
      @SerializedName("production_countries")
      var production_countries : List<production_country>,
      @SerializedName("release_date")
      var release_date : String,
      @SerializedName("revenue")
      var revenue : Int,
      @SerializedName("runtime")
      var runtime : Int,
      @SerializedName("spoken_languages")
      var spoken_languages : List<spoken_languages>,
      @SerializedName("status")
      var status : String,
      @SerializedName("tagline")
      var tagline : String,
      @SerializedName("title")
      var title : String,
      @SerializedName("video")
      var video : String,
      @SerializedName("vote_average")
      var vote_average : Double,
      @SerializedName("vote_count")
      var vote_count : Int
 )
{
   init {
       this.adult = adult
       this.backdrop_path = backdrop_path
       this.productionCompany = productionCompany
       this.belongs_to_collection = belongs_to_collection
       this.budget = budget
       this.genres = genres
       this.id = id
       this.homepage = homepage
       this.imdb_id = imdb_id
       this.original_title = original_title
       this.original_language = original_language
       this.overview = overview
       this.runtime = runtime
       this.revenue = revenue
       this.release_date = release_date
   }
}
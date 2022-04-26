package biz.filmeroo.premier.mywork.model

import com.google.gson.annotations.SerializedName
import dagger.Module
import kotlinx.android.parcel.Parcelize

@Module
@Parcelize
data class production_country (
        @SerializedName("iso_3166_1")
        var iso_3166_1: String,
        @SerializedName("name")
        var name : String)
{
  init {
      this.iso_3166_1 = iso_3166_1
      this.name = name
  }
}
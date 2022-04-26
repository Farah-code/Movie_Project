package biz.filmeroo.premier.mywork.model

import com.google.gson.annotations.SerializedName
import dagger.Module
import kotlinx.android.parcel.Parcelize

@Module
@Parcelize
data class spoken_languages
(
        @SerializedName("english_name")
        var english_name : String,
        @SerializedName("iso_639_1")
        var iso_639_1 : String,
        @SerializedName("name")
        var name : String
        )
{

}
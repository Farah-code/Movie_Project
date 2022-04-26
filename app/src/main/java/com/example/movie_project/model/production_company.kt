package biz.filmeroo.premier.mywork.model

import com.google.gson.annotations.SerializedName
import dagger.Module
import kotlinx.android.parcel.Parcelize

@Module
@Parcelize
data class production_company (
       @SerializedName("id")
       private var id : Int,
       @SerializedName("logo_path")
       private var logo_path : String,
       @SerializedName("name")
       private var name : String,
       @SerializedName("origin_country")
       private var origin_country : String

)
{
    init {
        this.id = id
        this.logo_path = logo_path
        this.name = name
        this.origin_country = origin_country
    }
}
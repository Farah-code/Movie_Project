package biz.filmeroo.premier.mywork.model

import com.google.gson.annotations.SerializedName
import dagger.Module
import kotlinx.android.parcel.Parcelize

@Module
@Parcelize
data class genric (
        @SerializedName("id")
        var id : Int,
        @SerializedName("name")
         var name : String)
          {

    init {
        this.id = id
        this.name = name
    }
}
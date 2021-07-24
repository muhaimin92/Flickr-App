package net.muhaimin.flickrapp.source.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosSearchResponse(

    @SerialName("photos")
    val photos: PhotosResponse,

    @SerialName("stat")
    val stat: String,
)

@Serializable
data class PhotosResponse(

    @SerialName("page")
    val page: Int,

    @SerialName("total")
    val total: Int,

    @SerialName("photo")
    val photoList: List<PhotoResponse>

)

@Serializable
data class PhotoResponse(
    @SerialName("url_m")
    val url: String,

    @SerialName("title")
    val title: String,

    @SerialName("id")
    val id: String,

    )


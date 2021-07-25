package net.muhaimin.flickrapp.domain.repository

import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.source.network.model.PhotosSearchResponse

interface PhotoRepository {

    suspend fun searchFromApi(apiKey: String, tag: String) : PhotosSearchResponse

    suspend fun insertLocal(photo: Photo)

    suspend fun getAllLocal(): List<Photo>


}
package net.muhaimin.flickrapp.source.remote

import net.muhaimin.flickrapp.source.remote.model.PhotosSearchResponse

interface PhotoService {
    suspend fun search(apiKey: String, tag: String) : PhotosSearchResponse
}
package net.muhaimin.flickrapp.source.remote

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import net.muhaimin.flickrapp.source.remote.model.PhotosSearchResponse

class PhotoServiceImpl: PhotoService {


    private val client: HttpClient = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun search(apiKey: String, tag: String): PhotosSearchResponse {
        return client.get("https://api.flickr.com/services/rest?api_key=f70aa071f9fb4ae2b082e41dd10d2054&method=flickr.photos.search&tags=electrolux&format=json&nojsoncallback=true&extras=media&extras=url_sq&extras=url_m&per_page=20&page=1"){
        }
    }
}
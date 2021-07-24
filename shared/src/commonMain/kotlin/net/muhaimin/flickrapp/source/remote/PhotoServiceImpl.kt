package net.muhaimin.flickrapp.source.remote

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import net.muhaimin.flickrapp.Constant.FLICKR_BASE_URL
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
        return client.get(FLICKR_BASE_URL+"?api_key=${apiKey}&method=flickr.photos.search&tags=${tag}&format=json&nojsoncallback=true&extras=media&extras=url_sq&extras=url_m&per_page=20&page=1"){
        }
    }
}
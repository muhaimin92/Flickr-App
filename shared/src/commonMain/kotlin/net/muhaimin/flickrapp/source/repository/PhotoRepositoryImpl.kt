package net.muhaimin.flickrapp.source.repository

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import net.muhaimin.flickrapp.Constant.FLICKR_BASE_URL
import net.muhaimin.flickrapp.db.AppDatabase
import net.muhaimin.flickrapp.db.PhotoDbQueries
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.domain.repository.PhotoRepository
import net.muhaimin.flickrapp.source.network.model.PhotosSearchResponse

class PhotoRepositoryImpl(private val appDatabase: AppDatabase): PhotoRepository {

    private val client: HttpClient = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
                ignoreUnknownKeys = true
            })
        }
    }

    private val queries : PhotoDbQueries = appDatabase.photoDbQueries


    override suspend fun searchFromApi(apiKey: String, tag: String): PhotosSearchResponse {
        return client.get(FLICKR_BASE_URL+"?api_key=${apiKey}&method=flickr.photos.search&tags=${tag}&format=json&nojsoncallback=true&extras=media&extras=url_sq&extras=url_m&per_page=20&page=1"){
        }
    }

    override suspend fun insertLocal(photo: Photo) {
        queries.insertPhoto(id = photo.id, url = photo.url, title = photo.title)
    }

    override suspend fun getAllLocal(): List<Photo> {
        val cacheResult = queries.selectAll().executeAsList()

        val list: ArrayList<Photo> = ArrayList()
        for (entity in cacheResult) {
            list.add(
                Photo(
                    id = entity.id,
                    title = entity.title,
                    url = entity.url,
                )
            )
        }

        return list;
    }
}
package net.muhaimin.flickrapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.muhaimin.flickrapp.db.AppDatabase
import net.muhaimin.flickrapp.domain.TaskResult
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.source.remote.PhotoService
import net.muhaimin.flickrapp.source.remote.mapper.PhotoEntityMapper

class GetPhoto(
    private val photoService: PhotoService,
    private val photoEntityMapper: PhotoEntityMapper,
    private val appDatabase: AppDatabase
) {

    fun execute(): Flow<TaskResult<List<Photo>>> = flow {
        try {

            val photoResponse = photoService.search("3", "1")

            val photos = photoEntityMapper.toDomainModel(photoResponse)

            val queries = appDatabase.photoDbQueries;
            for (photo in photos) {
                queries.insertPhoto(id = photo.id, url = photo.url, title = photo.title)
            }

            // query the cache
            val cacheResult = queries.selectAll().executeAsList()


            val list: ArrayList<Photo> = ArrayList()
            for (entity in cacheResult) {
                list.add(
                    Photo(
                        id = entity.id,
                        title = entity.title,
                        url = entity.title,

                        )
                )
            }

            emit(TaskResult.onSuccess(list))

        } catch (e: Exception) {
            emit(TaskResult.onError<List<Photo>>(e.message ?: "Unknown Error"))
        }


    }
}
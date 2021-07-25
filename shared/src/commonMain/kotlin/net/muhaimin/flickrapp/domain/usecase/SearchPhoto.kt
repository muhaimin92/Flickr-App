package net.muhaimin.flickrapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.muhaimin.flickrapp.domain.datamodel.TaskResult
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.domain.repository.PhotoRepository
import net.muhaimin.flickrapp.source.network.mapper.PhotoEntityMapper

class SearchPhoto(
    private val photoRepository: PhotoRepository,
    private val photoEntityMapper: PhotoEntityMapper
) {


    fun execute(tag:String): Flow<TaskResult<List<Photo>>> = flow {
        try {

            val photoResponse = photoRepository.searchFromApi("f70aa071f9fb4ae2b082e41dd10d2054", tag)

            val photos = photoEntityMapper.toDomainModel(photoResponse)

            for (photo in photos) {
                photoRepository.insertLocal(photo)
            }

            val list =  photoRepository.getAllLocal()

            emit(TaskResult.onSuccess(list))

        } catch (e: Exception) {
            emit(TaskResult.onError<List<Photo>>(e.message ?: "Unknown Error"))
        }


    }


}
package net.muhaimin.flickrapp.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.muhaimin.flickrapp.domain.TaskResult
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.source.remote.PhotoServiceImpl
import net.muhaimin.flickrapp.source.remote.mapper.PhotoEntityMapper

class GetPhoto {

    fun execute(): Flow<TaskResult<List<Photo>>> = flow {
        val photoResponse = PhotoServiceImpl().search("3","1")

        val photo = PhotoEntityMapper().toDomainModel(photoResponse)
        emit(TaskResult.onSuccess(photo))
    }
}
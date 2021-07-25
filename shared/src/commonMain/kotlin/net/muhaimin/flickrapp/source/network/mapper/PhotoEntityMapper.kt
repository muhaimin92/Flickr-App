package net.muhaimin.flickrapp.source.network.mapper

import net.muhaimin.flickrapp.domain.util.DomainMapper
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.source.network.model.PhotosSearchResponse
import net.muhaimin.flickrapp.utils.DateUtils

class PhotoEntityMapper : DomainMapper<PhotosSearchResponse, List<Photo>> {

    override fun toDomainModel(model: PhotosSearchResponse): List<Photo> {
        val list: ArrayList<Photo> = ArrayList()
        for (photoResponse in model.photosResponse.photoListResponse) {
            list.add(
                Photo(
                    id =photoResponse.id.toLong(),
                    title =photoResponse.title,
                    url =photoResponse.url,
                    dateAdded = DateUtils().currentDateTime()
                )
            )
        }
        return list;
    }

}
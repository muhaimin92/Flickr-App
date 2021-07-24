package net.muhaimin.flickrapp.source.remote.mapper

import net.muhaimin.flickrapp.domain.DomainMapper
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.source.remote.model.PhotosSearchResponse

class PhotoEntityMapper : DomainMapper<PhotosSearchResponse, List<Photo>> {

    override fun toDomainModel(model: PhotosSearchResponse): List<Photo> {
        val list: ArrayList<Photo> = ArrayList()
        for (photoResponse in model.photos.photoList) {
            list.add(
                Photo(
                    id =photoResponse.id,
                    title =photoResponse.title,
                    url =photoResponse.url
                )
            )
        }
        return list;
    }

}
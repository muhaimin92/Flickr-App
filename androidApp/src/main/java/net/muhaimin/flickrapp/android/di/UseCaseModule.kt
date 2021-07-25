package net.muhaimin.flickrapp.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.muhaimin.flickrapp.domain.repository.PhotoRepository
import net.muhaimin.flickrapp.source.network.mapper.PhotoEntityMapper
import net.muhaimin.flickrapp.domain.usecase.SearchPhoto
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideSearchPhoto(
        photoRepository: PhotoRepository,
        photoEntityMapper: PhotoEntityMapper
    ): SearchPhoto {
        return SearchPhoto(
            photoRepository = photoRepository,
            photoEntityMapper = photoEntityMapper
        )
    }
}
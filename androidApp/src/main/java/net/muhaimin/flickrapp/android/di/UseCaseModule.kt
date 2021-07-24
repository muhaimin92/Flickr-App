package net.muhaimin.flickrapp.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.muhaimin.flickrapp.db.AppDatabase
import net.muhaimin.flickrapp.source.remote.PhotoService
import net.muhaimin.flickrapp.source.remote.mapper.PhotoEntityMapper
import net.muhaimin.flickrapp.domain.usecase.SearchPhoto
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideSearchPhoto(
        photoService: PhotoService,
        photoEntityMapper: PhotoEntityMapper,
        appDatabase: AppDatabase
    ): SearchPhoto {
        return SearchPhoto(
            photoService = photoService,
            photoEntityMapper = photoEntityMapper,
            appDatabase = appDatabase
        )
    }
}
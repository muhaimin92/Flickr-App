package net.muhaimin.flickrapp.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.muhaimin.flickrapp.source.remote.PhotoService
import net.muhaimin.flickrapp.source.remote.PhotoServiceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun providePhotoService(): PhotoService {
        return PhotoServiceImpl()
    }
}
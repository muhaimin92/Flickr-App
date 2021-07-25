package net.muhaimin.flickrapp.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.muhaimin.flickrapp.db.AppDatabase
import net.muhaimin.flickrapp.domain.repository.PhotoRepository
import net.muhaimin.flickrapp.source.repository.PhotoRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePhotoService(appDatabase: AppDatabase): PhotoRepository {
        return PhotoRepositoryImpl(appDatabase)
    }
}
package net.muhaimin.flickrapp.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.muhaimin.flickrapp.android.BaseApplication
import net.muhaimin.flickrapp.db.AppDatabase
import net.muhaimin.flickrapp.source.db.DatabaseDriverFactory
import net.muhaimin.flickrapp.source.remote.mapper.PhotoEntityMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providePhotoDatabase(context: BaseApplication): AppDatabase {
        return AppDatabase(DatabaseDriverFactory(context).createDriver());
    }

    @Singleton
    @Provides
    fun providePhotoEntityMapper(): PhotoEntityMapper{
        return PhotoEntityMapper()
    }

}
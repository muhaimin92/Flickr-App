package net.muhaimin.flickrapp.android.viewmodel

import android.app.Application
import android.graphics.drawable.BitmapDrawable
import android.os.FileUtils
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import net.muhaimin.flickrapp.android.utils.FileUtil
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.domain.usecase.SearchPhoto
import javax.inject.Inject


@HiltViewModel
class PhotoViewModel
@Inject constructor(
    private val application: Application,
    private val searchPhoto: SearchPhoto
) : ViewModel() {

    val photos: MutableState<List<Photo>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val query = mutableStateOf("Electrolux")

    val selectedPhoto: MutableList<Photo> = ArrayList()

    fun search() {
        loading.value = true
        searchPhoto.execute(query.value).onEach {
            it.data?.let { list ->
                photos.value = list
            }

            it.errorMsg?.let { error ->
                Toast.makeText(application.applicationContext, error, Toast.LENGTH_SHORT).show()
            }
            loading.value = false
        }.launchIn(viewModelScope)
    }

    fun setQuery(query: String) {
        this.query.value = query
    }

    fun isPhotoSelected(photo: Photo, isSelected: Boolean) {
        if (isSelected)
            selectedPhoto.add(photo)
        else
            selectedPhoto.filter { it.id == photo.id }.forEach { selectedPhoto.remove(it) }

    }

    fun downloadSelectedPhoto() {
        if (selectedPhoto.isEmpty())
            Toast.makeText(application.applicationContext, "no photo selected", Toast.LENGTH_SHORT)
                .show()
        else
            download()


    }

    private fun download() {
        loading.value = true
        viewModelScope.launch {
            selectedPhoto.forEach {
                val imageLoader = ImageLoader(application)
                val request = ImageRequest.Builder(application)
                    .data(it.url)
                    .build()
                val result = (imageLoader.execute(request) as SuccessResult).drawable
                val bitmap = (result as BitmapDrawable).bitmap
                FileUtil.saveMediaToStorage(bitmap,application)
            }

            loading.value = false
            Toast.makeText(application.applicationContext, "download completed", Toast.LENGTH_SHORT)
                .show()
        }
    }

}
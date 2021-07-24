package net.muhaimin.flickrapp.android.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.domain.usecase.SearchPhoto
import javax.inject.Inject


@HiltViewModel
class PhotoViewModel
@Inject constructor(
    private val searchPhoto: SearchPhoto
) : ViewModel() {

    val photos: MutableState<List<Photo>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val query = mutableStateOf("Electrolux")

    fun search() {
        loading.value = true
        searchPhoto.execute(query.value).onEach {
            it.data?.let { list ->
                photos.value = list
            }

            it.errorMsg?.let { error ->
                println("nabilah error " + error)
            }
            loading.value = false
        }.launchIn(viewModelScope)
    }

    fun setQuery(query: String) {
        this.query.value = query
    }
}
package net.muhaimin.flickrapp.android.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import net.muhaimin.flickrapp.domain.model.Photo
import net.muhaimin.flickrapp.domain.usecase.SearchPhoto
import javax.inject.Inject


@HiltViewModel class PhotoViewModel
@Inject constructor(
    private val app : Application,
    private val searchPhoto: SearchPhoto
    ):ViewModel(){

    val loading: MutableState<Boolean> = mutableStateOf(false)
    val query: MutableState<Boolean> = mutableStateOf(false)

    fun search(){
       viewModelScope.launch {
           searchPhoto.execute("Electrolux").collect {
              for(p in it.data as List<Photo>){
                  println("nabilah "+p)
              }
           }
       }
    }
}
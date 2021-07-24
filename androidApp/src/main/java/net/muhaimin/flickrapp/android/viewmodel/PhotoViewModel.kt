package net.muhaimin.flickrapp.android.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel class PhotoViewModel
@Inject constructor():ViewModel(){

    val loading: MutableState<Boolean> = mutableStateOf(false)
}
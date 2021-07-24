package net.muhaimin.flickrapp.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import net.muhaimin.flickrapp.android.component.PhotoCard
import net.muhaimin.flickrapp.android.viewmodel.PhotoViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)
        viewModel.search()
        setContent {
            PhotoCard (
                onClick = {

                }
            )
        }
    }
}

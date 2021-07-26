package net.muhaimin.flickrapp.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import net.muhaimin.flickrapp.android.component.PhotoCard
import net.muhaimin.flickrapp.android.component.ProgressBar
import net.muhaimin.flickrapp.android.component.SearchToolbar
import net.muhaimin.flickrapp.android.viewmodel.PhotoViewModel
import net.muhaimin.flickrapp.domain.model.Photo


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PhotoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.search()

        setContent {

            Scaffold(
                topBar = {
                    SearchToolbar(
                        query = viewModel.query.value,
                        onQueryChanged = { viewModel.setQuery(it) },
                        onSearchClicked = { viewModel.search() },
                        onSaveClicked = { viewModel.downloadSelectedPhoto()}
                    )
                },
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    LazyColumn {
                        itemsIndexed(
                            items = viewModel.photos.value
                        ) { index, item ->
                            PhotoCard(
                                photo = item,
                                onSelectedPhoto = { photo, isSelected ->
                                    viewModel.isPhotoSelected(
                                        photo,
                                        isSelected
                                    )
                                }
                            )
                        }

                    }
                    ProgressBar(isDisplayed = viewModel.loading.value)
                }

            }

        }
    }
}

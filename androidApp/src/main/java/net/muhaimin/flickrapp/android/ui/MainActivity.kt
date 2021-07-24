package net.muhaimin.flickrapp.android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.muhaimin.flickrapp.Greeting
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import dagger.hilt.android.AndroidEntryPoint
import net.muhaimin.flickrapp.android.component.PhotoCard

fun greet(): String {
    return Greeting().greeting()
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoCard (
                onClick = {

                }
            )
        }
    }
}

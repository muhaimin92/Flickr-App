package net.muhaimin.flickrapp.android.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.muhaimin.flickrapp.android.R

@Composable
fun SearchToolbar(
    query:String,
    onQueryChanged: (String) -> Unit,
    onSearchClicked: () -> Unit,
    onSaveClicked: () -> Unit,
){
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            TextField(
                modifier = Modifier
                    .padding(8.dp),
                value = query,
                onValueChange = { onQueryChanged(it)},
                label = { Text(text = "Search") },
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
            )

            IconButton(
                onClick = { onSearchClicked() },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    Icons.Filled.Search,
                    "contentDescription",
                    tint = Color.Blue)
            }

            IconButton(
                onClick = { onSaveClicked() },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_save),
                    "contentDescription",
                    tint = Color.Blue)
            }

        }
    }

}
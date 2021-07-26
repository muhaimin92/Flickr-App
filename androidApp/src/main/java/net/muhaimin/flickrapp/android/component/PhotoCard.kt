package net.muhaimin.flickrapp.android.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import net.muhaimin.flickrapp.android.R
import net.muhaimin.flickrapp.domain.model.Photo


@Composable
fun PhotoCard(
    photo: Photo,
    onSelectedPhoto: (photo: Photo,isSelected:Boolean) -> Unit
) {
    val selected = remember { mutableStateOf(false) }

    Card(

        shape = RoundedCornerShape(4.dp),
        elevation = 5.dp,
        modifier = Modifier
            .padding(
                start = 15.dp,
                top = 15.dp,
                end = 15.dp,
                bottom = 15.dp
            )
            .fillMaxWidth()
            .clickable {
                selected.value = !selected.value
                onSelectedPhoto(photo,selected.value)
            }
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {

            Image(
                painter = rememberImagePainter(
                    data =photo.url,
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = photo.title,
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }

            Surface(
                color = if(selected.value) Color.Blue.copy(alpha = 0.6f) else MaterialTheme.colors.surface.copy(alpha = 0f),
                modifier = Modifier.fillMaxSize()
            ){

            }
        }
    }
}
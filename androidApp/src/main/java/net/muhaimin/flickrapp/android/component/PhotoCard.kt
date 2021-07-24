package net.muhaimin.flickrapp.android.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.muhaimin.flickrapp.android.R

@Composable
fun PhotoCard(
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                top = 10.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column {

            Row(
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        bottom = 10.dp,
                        top = 10.dp,
                        end = 10.dp
                    )

            ) {
                Text(
                    text = "hai",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.Start)
                )

                Text(
                    text = "hai",
                    modifier = Modifier
                        .wrapContentWidth(Alignment.End)
                )
            }

        }
    }
}
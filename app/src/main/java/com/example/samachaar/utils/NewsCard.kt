package com.example.samachaar.utils


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.samachaar.R
import com.example.samachaar.model.NewsDataClass

@Composable
fun NewsCard(
    modifier: Modifier,
    data: NewsDataClass

) {
    var totalNewsItem = data.articles.size
    var newsItemNumber by remember {
        mutableStateOf(0)
    }
    val textContent = data.articles[newsItemNumber]

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
                .weight(0.5f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "News app by An@nD", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.onPrimary)
        }
        if (textContent.urlToImage != null) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(textContent.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .weight(4f)
                    .background(Color.Black)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = "placeholder",
                Modifier
                    .weight(4f)
                    .background(Color.Black),
                contentScale = ContentScale.Fit
            )
        }




        if (textContent.title != null) {
            Text(
                text = textContent.title,
                Modifier
                    .weight(1f)
                    .padding(10.dp),
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        } else {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
            )
        }

        if (textContent.description != null) {
            Text(
                text = textContent.description,
                Modifier
                    .weight(0.5f)
                    .padding(10.dp),
                style = MaterialTheme.typography.caption,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        } else {
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(10.dp)
            )
        }
        if (textContent.content != null) {
            Text(
                text = textContent.content,
                Modifier
                    .weight(2.5f)
                    .padding(10.dp),
                style = MaterialTheme.typography.subtitle1,
                overflow = TextOverflow.Ellipsis,
                maxLines = 10
            )
        } else {
            Box(
                modifier = Modifier
                    .weight(2.5f)
                    .padding(10.dp)
            )
        }

        Row(
            Modifier
                .weight(1f)
                .padding(10.dp)
        ) {
            Text(text = textContent.publishedAt)
            Spacer(modifier = Modifier.weight(1f))
            Column() {
                if (textContent.source.name != null) {
                    Text(text = textContent.source.name)
                }

                if (textContent.author != null) {
                    Text(text = textContent.author)
                }
            }
        }


        Row(
            Modifier
                .weight(0.5f)
                .background(Color.LightGray)
        ) {

            if (newsItemNumber >= 1) {
                OutlinedButton(
                    onClick = { newsItemNumber-- },
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(text = "Back")
                }
            }
            Spacer(modifier = Modifier.weight(1f))



            if (newsItemNumber < totalNewsItem - 1) {
                OutlinedButton(
                    onClick = {
                        newsItemNumber++
                    },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text(text = "Next")
                }
            }


        }
    }
}


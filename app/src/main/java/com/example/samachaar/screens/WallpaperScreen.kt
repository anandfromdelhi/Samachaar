package com.example.samachaar.screens

import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

@Composable
fun WallpaperScreen(
    modifier: Modifier = Modifier
) {
    val imgLink = "https://wallpaperaccess.com/full/1687672.jpg"
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val wallpaperManager = WallpaperManager.getInstance(context)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context = context)
                    .crossfade(true)
                    .data(imgLink)
                    .size(Size.ORIGINAL)
                    .build()
            ),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,

            )
        OutlinedButton(onClick = {
            try {
                coroutineScope.launch {
                    val task = async(Dispatchers.IO) {
                        BitmapFactory.decodeStream(
                            URL(imgLink).openConnection().getInputStream()

                        )
                    }
                    val bitmap = task.await()
                    wallpaperManager.setBitmap(
                        bitmap,
                        null,
                        false,
                        WallpaperManager.FLAG_LOCK
                    )
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
            Toast.makeText(context,"Wallpaper set successfully",Toast.LENGTH_SHORT).show()

        }) {
            Text(text = "Set as lock screen wallpaper")
        }
        OutlinedButton(onClick = {

            try {
                coroutineScope.launch {
                    val task = async(Dispatchers.IO) {
                        BitmapFactory.decodeStream(
                            URL(imgLink).openConnection().getInputStream()

                        )
                    }
                    val bitmap = task.await()
                    wallpaperManager.setBitmap(
                        bitmap,
                        null,
                        false,
                        WallpaperManager.FLAG_SYSTEM
                    )
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
            Toast.makeText(context,"Wallpaper set successfully",Toast.LENGTH_SHORT).show()

        }) {
            Text(text = "Set as home screen wallpaper")
        }
        OutlinedButton(onClick = {

            try {
                coroutineScope.launch {
                    val task = async(Dispatchers.IO) {
                        BitmapFactory.decodeStream(
                            URL(imgLink).openConnection().getInputStream()

                        )
                    }
                    val bitmap = task.await()
                    wallpaperManager.setBitmap(bitmap)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
            Toast.makeText(context,"Wallpaper set successfully",Toast.LENGTH_SHORT).show()

        }) {
            Text(text = "Set wallpaper for both")
        }
    }

}


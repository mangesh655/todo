package com.mangesh.movieloading.ui


/**
 * Created by Mangesh on 6/6/2024.
 * We are downloading an image from URL and caching it in memory
 * and then showing the image.
 *
 *
 * Functinal requirements:
 * 1. Download the image from URL.
 * 2. Cache the image in memory & disk.
 * 3. Show the image in the UI either from cache or else follow 1 & 2.
 * 4. While downloading the image, if there is an error, show a placeholder image.
 */

//API
//Question {
//asset :Asset {
// String url;
// String type;
// }
//
// }

//s3 bucket --> https://s3.amazonaws.com/qustions-images/xykljkasdk.png

data class Asset(
    val id: String, //q1_1, q1_2, q2_1, q2_2
    val createdAt: Long, //timestamp
    val url: String,
    val type: String //png, jpg, mp4, mp3
)

class ImageDownloader {

    fun downloadImage(url: String): ByteArray {
        //Download the image from URL and return the byte array.
        //code to download image....
        return ByteArray(0)
    }
}

class ImageCachingHelper {

    val imageCache = HashMap<String, ByteArray>()

    fun storeImage(asset: Asset)  {
        //Download the image from URL.
        val byteArray = ImageDownloader().downloadImage(asset.url)
        //Cache the image in memory & disk.
        imageCache[asset.id+asset.createdAt] = byteArray
    }


}
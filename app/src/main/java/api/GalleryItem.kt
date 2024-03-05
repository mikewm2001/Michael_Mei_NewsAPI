package api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItem(
    val title: String?,
    @Json(name = "source") val id: GalleryItemId,
    @Json(name = "urlToImage") val urlToImage: String?,
    @Json(name = "url") val url: String,
    @Json(name = "author") val author: String?,
    @Json(name = "content") val content: String?,
)

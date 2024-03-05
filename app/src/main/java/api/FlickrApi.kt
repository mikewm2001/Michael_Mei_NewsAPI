package api

import retrofit2.http.GET

//private const val API_KEY = "76508858e1988d0a847f54c4165693a0"
//private const val API_KEY = "4909a7fb7bed2d75cedbc2e6e691755b"
private const val API_KEY = "682849086e194c7f97eab9d503ff8477"


interface FlickrApi {
    @GET(
        "v2/top-headlines?" +
                "country=us" +
                "&apiKey=$API_KEY"
    )
    suspend fun fetchPhotos(): FlickrResponse
}

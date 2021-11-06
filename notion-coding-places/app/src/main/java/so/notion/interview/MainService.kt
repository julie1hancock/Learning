package so.notion.interview

import retrofit2.http.*
import io.reactivex.Observable

interface MainService {

    @GET("json")
    fun getPlaces(
        @Query("input") input: String,
        @Query("key") apiKey: String
    ): Observable<PlaceResult>

}

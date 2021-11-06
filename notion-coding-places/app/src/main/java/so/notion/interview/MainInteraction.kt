package so.notion.interview

import io.reactivex.Observable

interface MainInteraction {
    fun getLocationResults(input: String): Observable<PlaceResult>
}

class MainInteractor(
    private val service: MainService
): MainInteraction {
    override fun getLocationResults(input: String): Observable<PlaceResult> {
        return service.getPlaces(
            input = input,
            apiKey = "AIzaSyDvuUazszd5ljI1-M-EP5Is2o_HrHvlWQE" //todo: put in manifest
        )
    }

}
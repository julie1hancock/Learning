package so.notion.interview

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//normally, you'd inject this, but I ran out of time
object Factory {

    fun createService(): MainService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/place/autocomplete/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(MainService::class.java)
    }

    fun createViewModel(): MainViewModel {
        return MainViewModel(MainInteractor(createService()))
    }
}